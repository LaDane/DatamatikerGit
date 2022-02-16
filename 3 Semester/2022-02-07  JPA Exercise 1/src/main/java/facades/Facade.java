package facades;

import entity.Child;
import entity.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Facade {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

    public void create(Parent p) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            p.getChildren().forEach(child -> {
                if (child.getId() == null)
                    em.persist(child);
                if (em.find(Child.class, child.getId()) == null)
                    em.persist(child);
            });
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

    public static void main(String[] args) {
        Facade facade = new Facade();
        Parent parent = new Parent("Helga", 23);

        EntityManager em = emf.createEntityManager();
        TypedQuery<Child> tq = em.createQuery("SELECT c FROM Child c WHERE c.name=:name", Child.class);
        tq.setParameter("name", "Ole");
        List<Child> children = tq.getResultList();
        Child ole = children.get(0);
        parent.addChild(ole);

//        Child child = new Child("Ole", 4);
//        parent.addChild(child);

        facade.create(parent);
    }
}
