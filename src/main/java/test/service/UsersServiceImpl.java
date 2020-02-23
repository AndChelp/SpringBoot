package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.UsersDAO;
import test.model.User;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDAO usersDAO;

    @Override
    public void insert(User user) {
        usersDAO.insert(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Override
    public User getUserByID(long id) {
        return null;
    }

    @Override
    public boolean deleteUserByID(long id) {
        return false;
    }
}
