package dk.tysker.getrequests.facade;

import dk.tysker.getrequests.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Generate {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();

            Customer c1 = new Customer("Steve", "Taylor");
            Customer c2 = new Customer("Michelle", "Schmidt");
            Customer c3 = new Customer("Marc", "Johannson");
            Customer c4 = new Customer("Jörg", "Oertel");

            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);

            em.getTransaction().commit();

        } finally {
            em.close();
            emf.close();
        }
    }
}
