package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static final String INSERT_STUDENT = "INSERT INTO users (first_name, last_name, birthday, address) " +
            "VALUES (?, ?, ?, ?)";
    private static final String GET_USER_ID = "SELECT user_id FROM users where first_name = ? and last_name = ? and " +
            "birthday = ? and address = ?;";

    public static void insertUser(DBConnector dbConnector, User user) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_STUDENT);
        try {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getBirthday()));
            statement.setString(4, user.getAddress());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static long getUserId(DBConnector dbConnector, User user) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_USER_ID);
        try {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getBirthday()));
            statement.setString(4, user.getAddress());
            ResultSet resultSet = statement.executeQuery();
            long userId = 0;
            while (resultSet.next()) {
                userId = resultSet.getLong(1);
            }
            return userId;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

}
