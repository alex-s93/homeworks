package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Order;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDao {
    private static final String INSERT_ORDER = "INSERT INTO orders (product_id, user_id, count, status, order_date) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ORDER_ID = "SELECT order_id FROM orders WHERE product_id = ? and user_id = ? " +
            "and status = ? and order_date = ?";

    public static void insertOrder(DBConnector dbConnector, Order order) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_ORDER);
        try {
            statement.setLong(1, order.getProduct().getId());
            statement.setLong(2, order.getUser().getId());
            statement.setInt(3, order.getCount());
            statement.setString(4, order.getStatus().name());
            statement.setDate(5, Date.valueOf(order.getOrderDate().toLocalDate()));
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public static long getOrderId(DBConnector dbConnector, Order order) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_ORDER_ID);
        try {
            statement.setLong(1, order.getProduct().getId());
            statement.setLong(2, order.getUser().getId());
            statement.setString(3, order.getStatus().name());
            statement.setDate(4, Date.valueOf(order.getOrderDate().toLocalDate()));
            ResultSet resultSet = statement.executeQuery();
            long orderId = 0;
            while (resultSet.next()) {
                orderId = resultSet.getLong(1);
            }
            return orderId;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
