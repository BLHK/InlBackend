package se.sero.project.resource;

import org.springframework.stereotype.Component;
import se.sero.project.data.Todo;
import se.sero.project.data.User;
import se.sero.project.service.TodoService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static javax.ws.rs.core.Response.Status.NO_CONTENT;

@Component
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
@Path("todos")
public class TodoResource {

    @Context
    private UriInfo uriInfo;

    @Context
    private HttpHeaders headers;

    private final TodoService service;

    public TodoResource(TodoService service) {
        this.service = service;
    }

    @POST
    public Response createTodo(Todo todo){
        Todo result = service.createTodo(todo);
        return Response.status(CREATED).header("Location", "todos/" + result.getId()).build();
    }


    @GET
    @Path("{id}")
    public Response getTodo(@PathParam("id") Long id) {
        return service.getTodo(id)
                .map(Response::ok)
                .orElse(Response.status(NOT_FOUND))
                .build();
    }

    @GET
    public Response getAll() {
        List<Todo> todos = service.getAll();
        return Response.ok(todos).build();
    }


    @DELETE
    @Path("{id}")
    public boolean deleteTodo(@PathParam("id") Long id) {
        return service.deleteTodo(id);
    }

    /*
    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") Long id) {
        return service.deleteTodo(id).map(c -> Response.status(NO_CONTENT)).orElse(Response.status(NOT_FOUND)).build();
    }

    @GET
    public Response getAll() {
        List<User> users = service.getAllUsers();
        return Response.ok(users).build();
    }*/
}
