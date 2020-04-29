package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    boolean addUser(User user);

    void delete(Long id);

    void editUser(User user);

    User getUserById(Long id);

    User getUserByName(String s);
}

