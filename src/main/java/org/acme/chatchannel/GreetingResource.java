package org.acme.chatchannel;

import io.smallrye.mutiny.Uni;
import java.util.ArrayList;
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
//        Uni<List<Server>> servers = Server.findAll().list();
//        List<Server> servers = new ArrayList<>();
        Server server1 = new Server();
        server1.name = "SERVER 1";

        Server server2 = new Server();
        server2.name = "SERVER 2";

        return Uni.combine().all()
            .unis(server1.persist(), server2.persist())
            .combinedWith(
                responses -> {
                    return responses;
                }
            ).onItem().transformToUni(servers -> {
                user.servers = servers.stream().map(e -> (Server) e).collect(Collectors.toList());
                return user.persist();
            });
    }

    @GET
    @Path("/server")
    public void createServer() {

    }
}