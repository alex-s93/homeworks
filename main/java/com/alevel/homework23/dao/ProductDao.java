package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;
import com.alevel.homework23.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductDao {

    private static final String INSERT_PRODUCT = "INSERT INTO products (name, price, category_id) VALUES (?, ?, ?)";
    private static final String GET_PRODUCT_ID = "SELECT product_id FROM products where name = ? and price = ? and " +
            "category_id = ?;";
    private static final String GET_COUNT_OF_PRODUCTS_BY_NAME = "SELECT count(*) FROM products where name = ?;";
    private static final String SHOW_PRODUCTS = "SELECT * FROM products";
    private static final String GET_PRODUCT_BY_NAME = "SELECT * FROM products where name = ?";
    private static final String GET_PRODUCT_BY_ID = "SELECT * FROM products where product_id = ?";

    public static void insertProduct(DBConnector dbConnector, Product product) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_PRODUCT);
        try {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setLong(3, product.getCategory().getId());
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static long getProductId(DBConnector dbConnector, Product product) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_PRODUCT_ID);
        try {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setLong(3, product.getCategory().getId());
            ResultSet resultSet = statement.executeQuery();
            long productId = 0;
            while (resultSet.next()) {
                productId = resultSet.getLong(1);
            }
            return productId;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static int getCountOfProductsByName(DBConnector dbConnector, String name) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_COUNT_OF_PRODUCTS_BY_NAME);
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

    public static Product getProductByName(DBConnector dbConnector, String name) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_PRODUCT_BY_NAME);
        try {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                product = buildProduct(dbConnector, resultSet);
            }
            return product;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    static Product getProductById(DBConnector dbConnector, long id) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_PRODUCT_BY_ID);
        try {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Product product = null;
            while (resultSet.next()) {
                product = buildProduct(dbConnector, resultSet);
            }
            return product;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static Product buildProduct(Category category, String name, double price) {
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    private static Product buildProduct(DBConnector dbConnector, ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("product_id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(Double.parseDouble(resultSet.getString("price")));
        long categoryId = resultSet.getLong("category_id");
        String categoryName = CategoryDao.getCategoryNameById(dbConnector, categoryId);
        Category category = CategoryDao.buildCategory(categoryName);
        category.setId(categoryId);
        product.setCategory(category);

        return product;
    }

    public static boolean updateProduct(DBConnector dbConnector, String name, Map<String, String> newValues) {
        String parameters = "";
        for (Map.Entry<String, String> item : newValues.entrySet()) {
            if (item.getKey().equals("category name")) {
                Category category = CategoryDao.buildCategory(item.getValue());
                CategoryDao.insertCategoryIfNotExist(dbConnector, category);
                long id = CategoryDao.getCategoryId(dbConnector, category);
                parameters += "category_id = \"" + id + "\", ";
            } else {
                parameters += item.getKey() + " = \"" + item.getValue() + "\", ";
            }
        }
        parameters = parameters.substring(0, parameters.length() - 2);
        String query = "UPDATE products SET " + parameters + " where name = \"" + name + "\";";

        final PreparedStatement statement = dbConnector.getPreparedStatement(query);
        try {
            return 1 == statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static List<Product> getAll(DBConnector dbConnector) {
        final ResultSet resultSet = dbConnector.executeQuery(SHOW_PRODUCTS);

        return processResult(dbConnector, resultSet);
    }

    private static List<Product> processResult(DBConnector dbConnector, ResultSet resultSet) {
        List<Product> products = new ArrayList<>();

        try {
            while (resultSet.next()) {
                products.add(buildProduct(dbConnector, resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return products;
    }
}
