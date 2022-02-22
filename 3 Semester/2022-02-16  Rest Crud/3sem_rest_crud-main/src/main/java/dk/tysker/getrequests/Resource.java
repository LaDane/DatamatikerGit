package dk.tysker.getrequests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.tysker.getrequests.entity.Customer;
import dk.tysker.getrequests.facade.CustomerFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class Resource {

    CustomerFacade facade = new CustomerFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response hello(@PathParam("id") long id) {
        Customer c = facade.getCustomerById(id);

        return Response
                .ok()
                .entity(gson.toJson(c))
                .build();
    }

    @GET
    @Path("/all")
    @Produces("application/json")
    public Response getAllCustomers() {
        List<Customer> cList = facade.getAllCustomers();

        return Response
                .ok()
                .entity(gson.toJson(cList))
                .build();
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addCustomer(String jsonObject) {
        Customer c = gson.fromJson(jsonObject, Customer.class);
        facade.addCustomer(c);
        return Response
                .ok()
                .cookie(new NewCookie("newcustomer", c.getFirstName()))
                .entity(gson.toJson(c))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteCustomerById(@PathParam("id") long id) {
        facade.deleteCustomerById(id);
        return Response
                .ok()
                .build();
    }
}

