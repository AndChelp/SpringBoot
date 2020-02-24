package test.dao;

import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import test.model.User;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
        try {
            @Cleanup
            CallableStatement statement = getConnection().prepareCall("CALL add_user(?,?,?,?,?)");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setShort(3, user.getAge());
            statement.setBoolean(4, user.isHasPremium());
            statement.setDate(5, user.getLastAuthorization());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            @Cleanup
            Statement statement = getConnection().createStatement();
            @Cleanup
            ResultSet rs = statement.executeQuery("SELECT * FROM select_all_users()");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getShort("age"));
                user.setHasPremium(rs.getBoolean("haspremium"));
                user.setLastAuthorization(rs.getDate("lastauthorization"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserByID(long id) {
        User user = null;
        try {
            @Cleanup
            CallableStatement statement = getConnection().prepareCall("SELECT * FROM select_user(?)");
            statement.setLong(1, id);
            @Cleanup
            ResultSet rs = statement.executeQuery();
            if (rs.next() && rs.getLong("id") != 0) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setAge(rs.getShort("age"));
                user.setHasPremium(rs.getBoolean("haspremium"));
                user.setLastAuthorization(rs.getDate("lastauthorization"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserByID(long id) {
        try {
            @Cleanup
            CallableStatement statement = getConnection().prepareCall("{ ? =  CALL exists_user(?)}");
            statement.registerOutParameter(1, Types.BOOLEAN);
            statement.setLong(2, id);
            statement.execute();
            if (statement.getBoolean(1)) {
                statement.close();
                statement = getConnection().prepareCall("CALL delete_user(?)");
                statement.setLong(1, id);
                statement.execute();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}























