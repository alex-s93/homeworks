package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

public class UserDao {
    private static final String INSERT_USER = "INSERT INTO users (first_name, last_name, birthday, address, email) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final String GET_USER_ID = "SELECT user_id FROM users WHERE first_name = ? and last_name = ? and " +
            "birthday = ? and address = ?;";
    private static final String GET_USER_ID_BY_EMAIL = "SELECT user_id FROM users WHERE email = ?;";
    private static final String GET_COUNT_OF_USERS_BY_EMAIL = "SELECT count(*) FROM users WHERE email = ?;";
    private static final String DELETE_USER_BY_EMAIL = "DELETE FROM users where email = ?";

    public static void insertUser(DBConnector dbConnector, User user) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_USER);
        try {
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setDate(3, Date.valueOf(user.getBirthday()));
            statement.setString(4, user.getAddress());
            statement.setString(5, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static boolean updateUser(DBConnector dbConnector, String email, Map<String, String> newValues) {
        String parameters = "";
        for (Map.Entry<String, String> item : newValues.entrySet()) {
            parameters += getDataBaseFieldName(item.getKey()) + " = \"" + item.getValue() + "\", ";
        }
        parameters = parameters.substring(0, parameters.length() - 2);
        String query = "UPDATE users SET " + parameters + " where email = \"" + email + "\";";

        System.out.println(query);
        final PreparedStatement statement = dbConnector.getPreparedStatement(query);
        try {
            return 1 == statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static String getDataBaseFieldName(String field) {
        String dbField = "";
        switch (field) {
            case "first name":
            case "last name":
                dbField = field.replace(" ", "_");
                break;
            case "date of birth":
                dbField = "birthday";
                break;
            case "address":
            case "email":
                dbField = field;
                break;
        }
        return dbField;
    }

    public static boolean deleteUser(DBConnector dbConnector, String email) {
        final PreparedStatement preparedStatement = dbConnector.getPreparedStatement(DELETE_USER_BY_EMAIL);
        try {
            preparedStatement.setString(1, email);

            return 1 == preparedStatement.executeUpdate();
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

    public static int getCountOfUsersByEmail(DBConnector dbConnector, String email) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_COUNT_OF_USERS_BY_EMAIL);
        try {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            return count;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static long getUserIdByEmail(DBConnector dbConnector, String email) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_USER_ID_BY_EMAIL);
        try {
            statement.setString(1, email);
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

    public static User buildUser(String firstName, String lastName, LocalDate birthday, String address, String email) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setAddress(address);
        user.setEmail(email);
        return user;
    }

}
