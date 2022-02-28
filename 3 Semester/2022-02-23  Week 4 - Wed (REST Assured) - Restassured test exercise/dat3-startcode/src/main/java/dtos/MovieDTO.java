/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Movie;
import java.util.ArrayList;
import java.util.List;

public class MovieDTO {
    private long id;
    private int year;
    private String title;
    private List<String> actors;

    public MovieDTO(int year, String title, List<String> actors) {
        this.year = year;
        this.title = title;
        this.actors = actors;
    }

    public MovieDTO(Movie movie) {
        if (movie.getId() != null) {
            this.id = movie.getId();
        }
        this.year = movie.getYear();
        this.title = movie.getTitle();
        this.actors = movie.getActors();
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", actors=" + actors +
                '}';
    }

    public static List<MovieDTO> getDtos(List<Movie> movies){
        List<MovieDTO> movieDTOs = new ArrayList<>();
        movies.forEach(movie->movieDTOs.add(new MovieDTO(movie)));
        return movieDTOs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }
}

//
//public class MovieDTO {
//    private long id;
//    private String str1;
//    private String str2;
//
//    public MovieDTO(String dummyStr1, String dummyStr2) {
//        this.str1 = dummyStr1;
//        this.str2 = dummyStr2;
//    }
//
//    public static List<MovieDTO> getDtos(List<Movie> rms){
//        List<MovieDTO> rmdtos = new ArrayList();
//        rms.forEach(rm->rmdtos.add(new MovieDTO(rm)));
//        return rmdtos;
//    }
//
//
//    public MovieDTO(Movie rm) {
//        if(rm.getId() != null)
//            this.id = rm.getId();
//        this.str1 = rm.getDummyStr1();
//        this.str2 = rm.getDummyStr2();
//    }
//
//    public String getDummyStr1() {
//        return str1;
//    }
//
//    public void setDummyStr1(String dummyStr1) {
//        this.str1 = dummyStr1;
//    }
//
//    public String getDummyStr2() {
//        return str2;
//    }
//
//    public void setDummyStr2(String dummyStr2) {
//        this.str2 = dummyStr2;
//    }
//
//    @Override
//    public String toString() {
//        return "RenameMeDTO{" + "id=" + id + ", str1=" + str1 + ", str2=" + str2 + '}';
//    }
//
//
//
//
//
//
//}
