package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.User;
import test.repository.UsersRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(User user) {
        usersRepository.save(user);

    }

    public List<User> findAll() {
        return usersRepository.findAll();
    }

    public User findUserByID(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUserByID(long id) {
        usersRepository.deleteById(id);
    }

}
