package test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import test.model.User;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class UsersDAOImpl extends JdbcDaoSupport implements UsersDAO {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public void insert(User user) {
        String sqlQuery = "INSERT INTO users (firstname, lastname, age, haspremium, lastauthorization) values (?, ?, ?, ?, ?)";
        if (getJdbcTemplate() != null) {
            getJdbcTemplate().update(sqlQuery, user.getFirstName(), user.getLastName(), user.getAge(), user.isHasPremium(), user.getLastAuthorization());
        }
    }

    @Override
    public List<User> getAllUsers() {
        String sqlQuery = "SELECT * FROM users";
        if (getJdbcTemplate() != null) {
            List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sqlQuery);
            List<User> result = new ArrayList<>();
            for (Map<String, Object> row : rows) {
                User user = new User();
                user.setId((int) row.get("id"));
                user.setFirstName((String) row.get("firstname"));
                user.setLastName((String) row.get("lastname"));
                user.setAge((int) row.get("age"));
                user.setHasPremium((boolean) row.get("haspremium"));
                user.setLastAuthorization((Date) row.get("lastauthorization"));
                result.add(user);
            }
            return result;
        }
        return null;
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























