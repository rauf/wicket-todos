package in.rauf.mappers;

import in.rauf.entities.UserEntity;
import in.rauf.models.User;

public class UserMapper {

    public static User mapEntity(UserEntity userEntity) {
        return new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail());
    }

    public static UserEntity mapModel(User user) {
        var userEntity = new UserEntity();
        userEntity.setId(user.id());
        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        return userEntity;
    }
}
