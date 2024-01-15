package in.rauf.services;

import in.rauf.models.User;

import java.io.Serializable;
import java.util.List;

public interface UserService extends Serializable {
    List<User> fetchAllUsers();

}
