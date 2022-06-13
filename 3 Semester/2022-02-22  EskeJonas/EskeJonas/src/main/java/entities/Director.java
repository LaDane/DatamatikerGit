package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @OneToMany(mappedBy = "director")
    private List<Movie> movies = new ArrayList<>();

    public Director() {
    }

    public Director(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        movie.setDirector(this);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
