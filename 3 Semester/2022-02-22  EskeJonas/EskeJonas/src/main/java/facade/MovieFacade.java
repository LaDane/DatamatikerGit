package facade;

import DTO.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

public class MovieFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");


    public List<MovieDTO> getAllMovies() {

        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Movie> typedQuery = em.createQuery("SELECT m FROM Movie m", Movie.class);

            List<Movie> movies = typedQuery.getResultList();
            List<MovieDTO> movieDTOs = new ArrayList<>();

            for (Movie movie : movies) {
                movieDTOs.add(new MovieDTO(movie));
            }

            return movieDTOs;

        } finally {
            em.close();
        }
    }
}
