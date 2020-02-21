package test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.model.User;
import test.repository.UsersRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class UserService {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
    private static EntityManager entityManager = factory.createEntityManager();
    @Autowired
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void createUser(User user) {
        usersRepository.save(user);

    }

    public List<User> findAll() {
        StoredProcedureQuery selectAllUsers = entityManager.createNamedStoredProcedureQuery("selectAllUsers");
        //System.out.println(selectAllUsers.getResultList());
        return usersRepository.findAll();
    }

    public User findUserByID(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public void deleteUserByID(long id) {
        usersRepository.deleteById(id);
    }

}
