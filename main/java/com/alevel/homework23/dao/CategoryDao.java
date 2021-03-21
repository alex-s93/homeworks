package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    private static final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?);";
    private static final String UPDATE_CATEGORY = "UPDATE categories SET name = ? where name = ?";
    private static final String GET_CATEGORY_ID = "SELECT category_id FROM categories where name = ?;";
    private static final String GET_CATEGORY_NAME = "SELECT name FROM categories where category_id = ?;";
    private static final String SHOW_CATEGORIES = "SELECT * FROM categories;";
    private static final String GET_COUNT_OF_CATEGORIES_BY_NAME = "SELECT count(*) FROM categories where name = ?;";

    public static void insertCategory(DBConnector dbConnector, Category category) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_CATEGORY);
        try {
            statement.setString(1, category.getName());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static void insertCategoryIfNotExist(DBConnector dbConnector, Category category) {
        if (CategoryDao.getCountOfCategoriesByName(dbConnector, category.getName()) == 0) {
            CategoryDao.insertCategory(dbConnector, category);
        }
    }

    public static boolean updateCategory(DBConnector dbConnector, String oldName, String newName) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(UPDATE_CATEGORY);

        try {
            statement.setString(1, newName);
            statement.setString(2, oldName);
            return 1 == statement.executeUpdate();
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

    static String getCategoryNameById(DBConnector dbConnector, long id) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_CATEGORY_NAME);
        try {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            String categoryName = "";
            while (resultSet.next()) {
                categoryName = resultSet.getString(1);
            }
            return categoryName;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static int getCountOfCategoriesByName(DBConnector dbConnector, String name) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_COUNT_OF_CATEGORIES_BY_NAME);
        try {
            statement.setString(1, name);
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

    public static List<Category> getAll(DBConnector dbConnector) {
        final ResultSet resultSet = dbConnector.executeQuery(SHOW_CATEGORIES);

        return processResult(resultSet);
    }

    private static List<Category> processResult(ResultSet resultSet) {
        List<Category> categories = new ArrayList<>();

        try {
            while (resultSet.next()) {
                categories.add(buildCategory(resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return categories;
    }

    public static Category buildCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }

    private static Category buildCategory(ResultSet resultSet) throws SQLException {
        Category category = new Category();
        category.setId(resultSet.getLong("category_id"));
        category.setName(resultSet.getString("name"));

        return category;
    }

}
