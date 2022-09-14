package org.acme.chatchannel.model;

import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserModel {

    private String id;

    private String name;

    private String email;

    private boolean active;

    private Collection<ObjectId> serverId;

}
