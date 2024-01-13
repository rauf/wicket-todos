package in.rauf.services;

import in.rauf.dao.UserDao;
import in.rauf.models.User;

import java.util.List;

public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> fetchAllUsers() {
        var userEntities = userDao.findAll();

        return userEntities.stream()
                .map(ue -> new User(ue.getId(), ue.getName(), ue.getEmail()))
                .toList();
    }

}
