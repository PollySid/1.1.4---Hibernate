package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserServiceImpl implements UserService {

                // service переиспользует методы dao

    public void createUsersTable() {
        try (Connection connection = Util.utilGetConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS test.Users " +
                    "(id BIGINT, name VARCHAR(30), lastName VARCHAR(30), age TINYINT)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Connection connection = Util.utilGetConnection();
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = Util.utilGetConnection();
    }

    public void removeUserById(long id) {
        Connection connection = Util.utilGetConnection();
    }

    public List<User> getAllUsers() {
        Connection connection = Util.utilGetConnection();
        return null;
    }

    public void cleanUsersTable() {
        Connection connection = Util.utilGetConnection();
    }
}
