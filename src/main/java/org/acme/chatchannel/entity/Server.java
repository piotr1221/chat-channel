package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import java.util.Collection;
import org.bson.types.ObjectId;

public class Server extends ReactivePanacheMongoEntity {

    public String name;

    public Collection<ObjectId> userId;

    public Collection<Role> roles;
}
