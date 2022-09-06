package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import java.util.Collection;
public class User extends ReactivePanacheMongoEntity {

    public String name;

    public String email;

    public String password;

    public boolean active;

    public Collection<Server> servers;
}
