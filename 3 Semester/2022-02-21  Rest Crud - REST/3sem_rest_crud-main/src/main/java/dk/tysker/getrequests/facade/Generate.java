package dk.tysker.getrequests.facade;

import dk.tysker.getrequests.entity.Customer;
import dk.tysker.getrequests.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Generate {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Customer c1 = new Customer("Steve", "Taylor", "Very low");
            Customer c2 = new Customer("Michelle", "Schmidt", "Desent ammount of money");
            Customer c3 = new Customer("Marc", "Johannson", "Poor guy");
            Customer c4 = new Customer("John", "Ritter", "Very bad customer");

            Employee e1 = new Employee("Hans", "Hansen");
            Employee e2 = new Employee("Jonas", "Jensen");
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.persist(e1);
            em.persist(e2);
            c1.addEmployee(e1);
            c2.addEmployee(e1);

            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }
}
