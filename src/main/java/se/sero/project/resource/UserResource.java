package se.sero.project.resource;

import org.springframework.stereotype.Component;
import se.sero.project.data.User;
import se.sero.project.service.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("users")
public final class UserResource {

    /*
    @Context
    private UriInfo uriInfo;

    @Context
    private HttpHeaders headers;
    */

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @POST
    public Response createUser(User user){
        User result = service.createUser(user);
        //URI location = uriInfo.getAbsolutePathBuilder().path(result.getId()).build();
        return Response.status(CREATED).header("Location", "users/" + result.getId()).build();
    }


    @GET
    public Response getAll() {
        List<User> users = service.getAllUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("{id}")
    public Response getUser(@PathParam("id") Long id) {
        return service.getUser(id)
                .map(Response::ok)
                .orElse(Response.status(NOT_FOUND))
                .build();
    }

    @DELETE
    @Path("{id}")
    public boolean deleteUser(@PathParam("id") Long id) {
        return service.deleteUser(id);
    }



    /* GJORD MEN BEHÖVS EJ
    @PUT
    @Path("{id}")
    public void updateUser(@PathParam("id") Long id, User user) {
        service.updateUser(user);
    }*/
}
