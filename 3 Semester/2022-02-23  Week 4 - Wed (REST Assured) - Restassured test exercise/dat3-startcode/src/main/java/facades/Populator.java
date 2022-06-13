/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade movieFacade = MovieFacade.getMovieFacade(emf);

        List<String> m1Actors = new ArrayList<>();
        m1Actors.add("HestePer");
        m1Actors.add("HestGok");
        movieFacade.create(new MovieDTO(new Movie(1997, "Horse Ride", m1Actors)));

        List<String> m2Actors = new ArrayList<>();
        m1Actors.add("CykelTyven");
        m1Actors.add("PerMadsen");
        movieFacade.create(new MovieDTO(new Movie(1956, "Per Cykel Tyv", m2Actors)));

        List<String> m3Actors = new ArrayList<>();
        m1Actors.add("James");
        m1Actors.add("Bond");
        movieFacade.create(new MovieDTO(new Movie(2012, "Bond James Adventures", m3Actors)));
//
//        fe.create(new MovieDTO(new Movie("First 1", "Last 1")));
//        fe.create(new MovieDTO(new Movie("First 2", "Last 2")));
//        fe.create(new MovieDTO(new Movie("First 3", "Last 3")));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
