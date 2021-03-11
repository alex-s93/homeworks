package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;
import com.alevel.homework23.entities.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

    private static final String INSERT_PRODUCT = "INSERT INTO products (name, price, category_id) VALUES (?, ?, ?)";
    private static final String GET_PRODUCT_ID = "SELECT product_id FROM products where name = ? and price = ? and " +
            "category_id = ?;";

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

    public static Product buildProduct(Category category, String name, double price) {
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
