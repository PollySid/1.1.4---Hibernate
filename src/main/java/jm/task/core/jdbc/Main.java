package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.List;

/*
         В методе main класса Main должны происходить следующие операции:
 1. Создание таблицы User(ов)
 2. Добавление 4 User(ов) в таблицу с данными на свой выбор.
    После каждого добавления должен быть вывод в консоль (User с именем – name добавлен в базу данных)
 3. Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
 4. Очистка таблицы User(ов)
 5. Удаление таблицы
 */

public class Main {
    public static void main(String[] args) {

        UserServiceImpl sqlWork = new UserServiceImpl();
        sqlWork.createUsersTable();

//        try {
//            String sql = "INSERT INTO test.Users (id, name, lastName, age) VALUES (?, ?, ?, ?)";
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            String name1 = "Lesha";
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, name1);
//            preparedStatement.setString(3, "retyuiop");
//            preparedStatement.setByte(4, (byte) 1);
//            preparedStatement.executeUpdate();
//            System.out.println("User с именем " + name1 + " добавлен в базу данных");
//
////            statement.executeUpdate("DROP TABLE test.Users");
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



    }
}
