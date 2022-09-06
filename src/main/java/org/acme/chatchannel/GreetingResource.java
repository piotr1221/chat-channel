package org.acme.chatchannel;

import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.acme.chatchannel.entity.Server;
import org.acme.chatchannel.entity.User;

@Path("/hello")
@Produces({MediaType.APPLICATION_JSON})
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/ra")
    public Uni<User> createUser() throws InterruptedException, ExecutionException {
        User user = new User();
        user.name = "ga";
        user.email = "ga@gmail.com";
        user.password = "123";
        user.active = true;
        Uni<List<Server>> servers = Server.findAll().list();
        user.servers = servers.convert().toCompletableFuture().get();
        return user.persist();
    }

    @GET
    @Path("/server")
    public Uni<Server> createServer() {
        Server s1 = new Server();
        s1.name = "S1";
        return s1.persist();
    }
}