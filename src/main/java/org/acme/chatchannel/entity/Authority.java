package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class Authority extends ReactivePanacheMongoEntity {

    public String name;
}
