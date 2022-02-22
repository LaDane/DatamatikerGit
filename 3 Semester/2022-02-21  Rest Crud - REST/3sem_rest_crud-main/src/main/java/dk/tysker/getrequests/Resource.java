package dk.tysker.getrequests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dk.tysker.getrequests.dtos.CustomerDTO;
import dk.tysker.getrequests.entity.Customer;
import dk.tysker.getrequests.facade.CustomerFacade;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class Resource {

    CustomerFacade facade = new CustomerFacade();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") long id) {
        CustomerDTO c = facade.getCustomerById(id);
        return Response
                .ok()
                .entity(gson.toJson(c))
                .build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomer() {
        List<CustomerDTO> c = facade.getAllCustomers();
        return Response
                .ok()
                .entity(gson.toJson(c))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(String jsonContext) {
        Customer c = gson.fromJson(jsonContext, Customer.class);
        Customer addCustomer = new Customer(c.getFirstName(), c.getLastName());
        return Response
                .ok("SUCCESS")
                .cookie(new NewCookie("test", c.getFirstName()))
                .entity(gson.toJson(facade.addCustomer(addCustomer)))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteCustomerById(@PathParam("id") long id) {
        CustomerDTO c = facade.deleteCustomerById(id);
        return Response.ok().entity(gson.toJson(c)).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomerByContext(String jsonContext, @PathParam("id") long id) {
        CustomerDTO customerToBeChanged = gson.fromJson(jsonContext, CustomerDTO.class);
        CustomerDTO updatedCustomer = facade.updateCustomer(customerToBeChanged, id);
        return Response.ok().entity(gson.toJson(updatedCustomer)).build();
    }

}

