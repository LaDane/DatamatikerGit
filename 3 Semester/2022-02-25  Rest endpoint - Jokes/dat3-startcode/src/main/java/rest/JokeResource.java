package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MyJokeDTO;
import facades.FacadeExample;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("joke")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("combined")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCombinedJoke() {
//        MyJokeDTO mjd = FACADE.getMyJoke();
        return Response.ok("SUCCESS")
                .entity(GSON.toJson(FACADE.getMyJoke()))
                .build();
    }

//    @Path("count")
//    @GET
//    @Produces({MediaType.APPLICATION_JSON})
//    public String getRenameMeCount() {
//
//        long count = FACADE.getRenameMeCount();
//        //System.out.println("--------------->"+count);
//        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
//    }
}
