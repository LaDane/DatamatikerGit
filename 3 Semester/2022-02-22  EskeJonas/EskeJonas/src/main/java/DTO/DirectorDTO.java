package DTO;

import entities.Director;
import entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class DirectorDTO {

    private long id;
    private String fname;
    private String lname;
    private List<MovieDTO> movieDTOs = new ArrayList<>();

    public DirectorDTO(Director director) {
        this.id = director.getId();
        this.fname = director.getFname();
        this.lname = director.getLname();
        for (Movie movie : director.getMovies()) {
            movieDTOs.add(new MovieDTO(movie));
        }
    }
}
