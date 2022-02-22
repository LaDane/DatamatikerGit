package dk.tysker.getrequests.facade;

import dk.tysker.getrequests.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Customer getCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class, id);
    }

    public List<Customer> getAllCustomers() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery query = em.createQuery("select c from Customer c", Customer.class);
            return query.getResultList();
        }
        finally {
            em.close();
        }
    }

    public void addCustomer(Customer c) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public void deleteCustomerById(long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Customer c = em.find(Customer.class, id);
            em.remove(c);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }
}
