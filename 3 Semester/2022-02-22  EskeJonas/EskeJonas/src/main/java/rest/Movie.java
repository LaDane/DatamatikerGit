package rest;

import DTO.MovieDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import facade.MovieFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/movie")
public class Movie {

    MovieFacade mf = new MovieFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllMovies() {
        List<MovieDTO> movies = mf.getAllMovies();

        for (MovieDTO movie : movies) {
            System.out.println(movie.getTitle());
        }

        return Response.ok().entity(gson.toJson(movies)).build();
    }
}