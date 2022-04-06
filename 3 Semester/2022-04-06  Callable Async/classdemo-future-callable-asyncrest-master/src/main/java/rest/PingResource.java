package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("serverstatus")
public class PingResource {

  private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  
  // Green (Yellow) students use this simple (no async strategy)
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("simple")
  public String getStatus(){
      return "{\"msg\":\"Make me return server status from all servers\"}";
  }
  
  // Red (Yellow) students use this async strategy, as recomended by the jersey documentation
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public void getServerStatus(@Suspended final AsyncResponse ar) {
     new Thread(() -> {
            try {
                Thread.sleep(2000);  //Simulate a long running process
            } catch (InterruptedException ex) {
                Logger.getLogger(PingResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.resume("{\"msg\":\"Make me return server status from all servers\"}");
        }).start();
  }
  
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("solution")
  public void getServerStatus2(@Suspended final AsyncResponse ar) throws Exception {
    System.out.println("---- A -------");
        new Thread(() -> {
            List<String> res = null;
            try {
                res = parallel.ParallelPinger.getStatusFromAllServers();
            } catch (Exception ex) {
                Logger.getLogger(PingResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("---- B -------" + res);
            ar.resume("{\"status\":\"" + GSON.toJson(res) + "\"}");
        }).start();
        System.out.println("---- C -------");
  }
    
}
