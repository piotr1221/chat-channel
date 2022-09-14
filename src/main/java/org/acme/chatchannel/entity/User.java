package org.acme.chatchannel.entity;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class User extends ReactivePanacheMongoEntity {

    public String name;

    public String email;

    public String password;

    public boolean active;

    public Collection<ObjectId> serverId;

}
