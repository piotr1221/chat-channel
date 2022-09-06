package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class Server extends ReactivePanacheMongoEntity {

    public String name;
}
