package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    boolean addUser(User user);

    void delete(User user);

    void editUser(User user);

    User getUserById(Long id);

    User getUserByNameAndPassword(String name, String password);
}
