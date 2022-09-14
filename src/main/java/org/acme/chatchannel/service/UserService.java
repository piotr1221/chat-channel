package org.acme.chatchannel.service;

import io.smallrye.mutiny.Uni;
import java.util.List;
import org.acme.chatchannel.model.UserModel;
import org.acme.chatchannel.model.UserRegistrationModel;

public interface UserService {

    Uni<List<UserModel>> getUsers();

    Uni<UserModel> getUser(String userId);

    Uni<UserModel> createUser(UserRegistrationModel userModel);

}
