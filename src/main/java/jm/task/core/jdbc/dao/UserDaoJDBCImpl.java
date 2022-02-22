package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
        // остаётся пустой
    }

    // здесь должна быть обработка всех исключений, связанных с работой с базой данных

    public void createUsersTable() {
        try (Connection connection = Util.utilGetConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS test.Users (" +
                            "id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                            "name VARCHAR(30), " +
                            "lastName VARCHAR(30), " +
                            "age TINYINT)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection connection = Util.utilGetConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP TABLE IF EXISTS test.Users");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection connection = Util.utilGetConnection()){
            String sql = "INSERT INTO test.Users(name, lastName, age) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();

            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection connection = Util.utilGetConnection()){
            String sql = "DELETE FROM test.Users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        try (Connection connection = Util.utilGetConnection();
             Statement statement = connection.createStatement()){

            List<User> users = new ArrayList<>();
            statement.execute("SELECT * FROM test.Users");
            ResultSet rs = statement.getResultSet();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setLastName(rs.getString("lastName"));
                user.setAge(rs.getByte("age"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cleanUsersTable() {
        try (Connection connection = Util.utilGetConnection();
             Statement statement = connection.createStatement()){

            statement.executeUpdate("TRUNCATE TABLE test.Users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
