package org.acme.chatchannel.controller;

import io.smallrye.mutiny.Uni;
import java.net.URI;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.acme.chatchannel.entity.User;
import org.acme.chatchannel.model.UserModel;
import org.acme.chatchannel.model.UserRegistrationModel;
import org.acme.chatchannel.service.UserService;
import org.acme.chatchannel.service.implementation.UserServiceImpl;
import org.bson.types.ObjectId;

@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
//@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    public Uni<Response> getUsers() {
        return userService.getUsers().onItem().transform(users -> Response.ok(users).build());
    }

    @GET
    @Path("/{userId}")
    public Uni<Response> getUser(@PathParam("userId") String userId) {
        return userService.getUser(userId).onItem().transform(user -> Response.ok(user).build());
    }

    @POST
    public Uni<Response> createUser(UserRegistrationModel user) {
        return userService.createUser(user).onItem().transform(
            createdUser -> Response.ok(createdUser).build());
    }
}
