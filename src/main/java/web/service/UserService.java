package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    void saveUser(User user);

    User getUserById(Long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}