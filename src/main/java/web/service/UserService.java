package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean addUser(User user);

    void delete(Long id);

    void editUser(User user);

    User getUserById(Long id);
}
