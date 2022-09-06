package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;

public class Role extends ReactivePanacheMongoEntity {

    public String name;
}
