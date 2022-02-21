package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
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

        sqlWork.dropUsersTable(); // потом удалить эту сточку

        User user1 = new User("Masha", "Ivanova", (byte) 10);
        User user2 = new User("Sonya", "Starova", (byte) 20);
        User user3 = new User("Lesha", "Shem", (byte) 15);
        User user4 = new User("Pasha", "Svoi", (byte) 25);

        sqlWork.createUsersTable();
        sqlWork.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        sqlWork.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        sqlWork.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        sqlWork.saveUser(user4.getName(), user4.getLastName(), user4.getAge());

        sqlWork.getAllUsers();

        sqlWork.dropUsersTable();

//        User user = new User(name, lastName, age);

    }
}
