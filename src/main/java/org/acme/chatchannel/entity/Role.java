package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import java.util.Collection;

public class Role extends ReactivePanacheMongoEntity {

    public String name;

    public Collection<Authority> authorities;
}
