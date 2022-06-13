package DTO;

import entities.Director;
import entities.Movie;

public class MovieDTO {

    private long id;
    private String title;
    private int releaseYear;
    private String genre;
    private String directorString;

    public MovieDTO(Movie movie) {

        this.id = movie.getId();
        this.title = movie.getTitle();
        this.releaseYear = movie.getReleaseYear();
        this.genre = movie.getGenre();
        this.directorString = movie.getDirector().getFname() + " " + movie.getDirector().getLname();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirectorString() {
        return directorString;
    }

    public void setDirectorString(String directorString) {
        this.directorString = directorString;
    }
}
