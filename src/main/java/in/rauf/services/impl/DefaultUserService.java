package in.rauf.services.impl;

import in.rauf.dao.UserDao;
import in.rauf.models.User;
import in.rauf.services.UserService;

import java.io.Serializable;
import java.util.List;

public class DefaultUserService implements UserService, Serializable {

    private final UserDao userDao;

    public DefaultUserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> fetchAllUsers() {
        var userEntities = userDao.findAll();

        return userEntities.stream()
                .map(ue -> new User(ue.getId(), ue.getName(), ue.getEmail()))
                .toList();
    }

}
