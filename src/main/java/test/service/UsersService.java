package test.service;

import test.model.User;

import java.util.List;

public interface UsersService {
    void insert(User user);

    List<User> getAllUsers();

    User getUserByID(long id);

    boolean deleteUserByID(long id);
}
