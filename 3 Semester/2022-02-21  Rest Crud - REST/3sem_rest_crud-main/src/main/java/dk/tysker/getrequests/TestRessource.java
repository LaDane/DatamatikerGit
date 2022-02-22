package dk.tysker.getrequests;

import javax.ws.rs.*;

@Path("/hello-world")
public class TestRessource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}