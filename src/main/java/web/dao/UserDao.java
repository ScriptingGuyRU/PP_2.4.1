package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    boolean addUser(User user);

    void delete(User user);

    void editUser(User user);

    User getUserById(Long id);

    User getUserByNameAndPassword(String name, String password);

    User getUserByName(String s);

    boolean validator(User user);
}

