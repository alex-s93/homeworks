package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDao {

    private static final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";
    private static final String GET_CATEGORY_ID = "SELECT category_id FROM categories where name = ?;";


    public static void insertCategory(DBConnector dbConnector, Category category) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_CATEGORY);
        try {

            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static long getCategoryId(DBConnector dbConnector, Category category) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_CATEGORY_ID);
        try {
            statement.setString(1, category.getName());
            ResultSet resultSet = statement.executeQuery();
            long categoryId = 0;
            while (resultSet.next()) {
                categoryId = resultSet.getLong(1);
            }
            return categoryId;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

}
