package dk.tysker.getrequests.facade;

import dk.tysker.getrequests.dtos.CustomerDTO;
import dk.tysker.getrequests.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public CustomerDTO getCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        return new CustomerDTO(em.find(Customer.class, id));
    }

    public long addCustomer(Customer customerDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(customerDTO);
            em.getTransaction().commit();
            return customerDTO.getId();
        } finally {
            em.close();
        }
    }

    public CustomerDTO deleteCustomerById(long customerId) {
        EntityManager em = emf.createEntityManager();
        try {
            Customer c = em.find(Customer.class, customerId);
            em.getTransaction().begin();

            if(c != null){
                em.remove(c);
                em.getTransaction().commit();
            } else {
                return null;
            }
            return new CustomerDTO(c);
        } finally {
            em.close();
            emf.close();
        }

    }

    public CustomerDTO updateCustomer(CustomerDTO customer, long customerId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Customer c = em.find(Customer.class, customerId);
            c.setFirstName(customer.getFirst());
            c.setLastName(customer.getLast());
            em.getTransaction().commit();
            return new CustomerDTO(c);
        } finally {
            em.close();
            emf.close();
        }
    }

    public List<CustomerDTO> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = em.createQuery("select c from Customer c", Customer.class);
            return CustomerDTO.getDTOs(query.getResultList());
        } finally {
            em.close();
            emf.close();
        }
    }
    public Set<Customer> getAllCustomersByEmp(Long emp_id) {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = em.createQuery("select c from Customer c JOIN c.employees e WHERE e.id = :id ", Customer.class);
            query.setParameter("id", emp_id);
            return new HashSet(CustomerDTO.getDTOs(query.getResultList()));
        } finally {
            em.close();
            emf.close();
        }
    }

    public static void main(String[] args) {
        CustomerFacade cf = new CustomerFacade();

        Set<Customer> customers = cf.getAllCustomersByEmp(1L);
        System.out.println(customers);
    }
}
