package facades;

import dtos.MovieDTO;
import entities.Movie;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

//import errorhandling.RenameMeNotFoundException;
import utils.EMF_Creator;


public class MovieFacade {
    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    private MovieFacade() {}            //Private Constructor to ensure Singleton

    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public MovieDTO create(MovieDTO pMovieDTO){
        Movie newMovie = new Movie(pMovieDTO.getYear(), pMovieDTO.getTitle(), pMovieDTO.getActors());

        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(newMovie);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new MovieDTO(newMovie);
    }

    public MovieDTO getById(long id) { //throws RenameMeNotFoundException {
        EntityManager em = emf.createEntityManager();
        Movie rm = em.find(Movie.class, id);
//        if (rm == null)
//            throw new RenameMeNotFoundException("The RenameMe entity with ID: "+id+" Was not found");
        return new MovieDTO(rm);
    }
    
    //TODO Remove/Change this before use
    public long getMovieCount(){
        EntityManager em = getEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM Movie r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
    }
    
    public List<MovieDTO> getAllMovies(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
        List<Movie> rms = query.getResultList();
        return MovieDTO.getDtos(rms);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = getMovieFacade(emf);
        fe.getAllMovies().forEach(dto->System.out.println(dto));
    }

    public Long addMovie(MovieDTO movieDTO) {
        EntityManager em = emf.createEntityManager();
        try {
            Movie movie = new Movie(movieDTO.getYear(), movieDTO.getTitle(), movieDTO.getActors());
            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();
            return movie.getId();
        } finally {
            em.close();
        }
    }

//    public List<MovieDTO> getAllMovies() {
//        EntityManager em = emf.createEntityManager();
//
//        try {
////            List<MovieDTO> mList = new ArrayList<>();
//            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m", Movie.class);
//            List<Movie> rms = query.getResultList();
//            return MovieDTO.getDtos(rms);
//        } finally {
//
//        }
//
//    }
}
