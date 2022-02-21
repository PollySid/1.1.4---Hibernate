package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String PASSWORD = "1234";
    private static final String USER = "root";

    public static Connection utilGetConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//                    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//                    Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                    Statement statement = connection.createStatement();
//                    ResultSet resultSet = statement.executeQuery(sql);