package facades;

import entities.Movie;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = MovieFacade.getMovieFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();

            List<String> m1Actors = new ArrayList<>();
            m1Actors.add("Heste Per");
            m1Actors.add("Hest Gok");
            em.persist(new Movie(1997, "Horse Ride", m1Actors));

            List<String> m2Actors = new ArrayList<>();
            m2Actors.add("Cykel Tyven");
            m2Actors.add("Per Madsen");
            m2Actors.add("Cykel Per");
            em.persist(new Movie(1956, "Per Cykel Tyv", m2Actors));

            List<String> m3Actors = new ArrayList<>();
            m3Actors.add("James");
            m3Actors.add("Bond");
            m3Actors.add("Mini Me");
            m3Actors.add("The One Eyed Villan");
            em.persist(new Movie(2012, "Bond James Adventures", m3Actors));

//            em.persist(new Movie("Some txt", "More text"));
//            em.persist(new Movie("aaa", "bbb"));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testDatabaseColumnCount() throws Exception {
        assertEquals(3, facade.getMovieCount(), "Expects two rows in the database");
    }
    

}
