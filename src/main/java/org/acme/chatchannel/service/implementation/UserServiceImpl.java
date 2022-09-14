package org.acme.chatchannel.service.implementation;

import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import org.acme.chatchannel.entity.User;
import org.acme.chatchannel.model.UserModel;
import org.acme.chatchannel.model.UserRegistrationModel;
import org.acme.chatchannel.service.UserService;
import org.bson.types.ObjectId;

@ApplicationScoped
public class UserServiceImpl implements UserService {
    @Override
    public Uni<List<UserModel>> getUsers() {
        return User.listAll().onItem().transform(
            users -> users.stream().map(user -> buildUserModel((User) user))
                .collect(Collectors.toList()));
    }

    @Override
    public Uni<UserModel> getUser(String userId) {
        return User.findById(new ObjectId(userId)).onItem()
            .transform(user -> buildUserModel((User) user));
    }

    @Override
    public Uni<UserModel> createUser(UserRegistrationModel userModel) {
        Uni<User> newUser = User.builder()
            .name(userModel.getName())
            .email(userModel.getEmail())
            .password(userModel.getPassword())
            .active(true)
            .build()
            .persist();

        return newUser.onItem().transformToUni(user -> getUser(user.id.toString()));
    }

    UserModel buildUserModel(User user) {
        return UserModel.builder()
            .id(user.id.toString())
            .name(user.name)
            .email(user.email)
            .active(user.active)
            .serverId(user.serverId)
            .build();
    }
}
