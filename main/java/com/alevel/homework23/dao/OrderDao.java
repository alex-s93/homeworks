package com.alevel.homework23.dao;

import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Order;
import com.alevel.homework23.entities.Product;
import com.alevel.homework23.entities.Status;
import com.alevel.homework23.entities.User;

import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {
    private static final String INSERT_ORDER = "INSERT INTO orders (product_id, user_id, count, status, order_date) " +
            "VALUES (?, ?, ?, ?, ?)";

    private static final String GET_ORDER_ID = "SELECT order_id FROM orders WHERE product_id = ? and user_id = ? " +
            "and status = ? and order_date = ?";
    private static final String SHOW_ORDERS = "SELECT * FROM orders;";
    private static final String GET_COUNT_OF_ORDERS_BY_ID = "SELECT count(*) FROM orders WHERE order_id = ?;";

    public static void insertOrder(DBConnector dbConnector, Order order) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(INSERT_ORDER);
        try {
            statement.setLong(1, order.getProduct().getId());
            statement.setLong(2, order.getUser().getId());
            statement.setInt(3, order.getCount());
            statement.setString(4, order.getStatus().name());
            statement.setTimestamp(5, order.getOrderDate());
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
            statement.setTimestamp(4, order.getOrderDate());
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

    private static Status getStatus(String name) {
        Status status = null;
        switch (name) {
            case "OPEN":
                status = Status.OPEN;
                break;
            case "IN_PROGRESS":
                status = Status.IN_PROGRESS;
                break;
            case "COMPLETED":
                status = Status.COMPLETED;
                break;
            case "CANCELED":
                status = Status.CANCELED;
                break;
        }
        return status;
    }

    public static List<Order> getAll(DBConnector dbConnector) {
        final ResultSet resultSet = dbConnector.executeQuery(SHOW_ORDERS);

        return processResult(dbConnector, resultSet);
    }

    private static List<Order> processResult(DBConnector dbConnector, ResultSet resultSet) {
        List<Order> orders = new ArrayList<>();

        try {
            while (resultSet.next()) {
                orders.add(buildOrder(dbConnector, resultSet));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return orders;
    }

    public static Order buildOrder(Product product, User user, String statusName, int count, Timestamp orderDate) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setStatus(getStatus(statusName));
        order.setCount(count);
        order.setOrderDate(orderDate);
        return order;
    }

    private static Order buildOrder(DBConnector dbConnector, ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setId(resultSet.getLong("order_id"));
        Product product = ProductDao.getProductById(dbConnector, resultSet.getLong("product_id"));
        order.setProduct(product);
        User user = UserDao.getUserById(dbConnector, resultSet.getLong("user_id"));
        order.setUser(user);
        order.setCount(resultSet.getInt("count"));
        order.setStatus(getStatus(resultSet.getString("status")));
        order.setOrderDate(resultSet.getTimestamp("order_date"));

        return order;
    }

    public static int getCountOfOrdersById(DBConnector dbConnector, long orderId) {
        final PreparedStatement statement = dbConnector.getPreparedStatement(GET_COUNT_OF_ORDERS_BY_ID);
        try {
            statement.setLong(1, orderId);
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

    public static boolean updateOrder(DBConnector dbConnector, long orderId, Map<String, String> newValues) {
        String parameters = "";
        for (Map.Entry<String, String> item : newValues.entrySet()) {
            switch (item.getKey()) {
                case "product name":
                    long productId = ProductDao.getProductByName(dbConnector, item.getValue()).getId();
                    parameters += "product_id = \"" + productId + "\", ";
                    break;
                case "count":
                case "status":
                    parameters += item.getKey() + " = \"" + item.getValue() + "\", ";
                    break;
                case "user email":
                    long userId = UserDao.getUserByEmail(dbConnector, item.getValue()).getId();
                    parameters += "user_id = \"" + userId + "\", ";
                    break;
            }
        }
        parameters = parameters.substring(0, parameters.length() - 2);
        String query = "UPDATE orders SET " + parameters + " where order_id = " + orderId + ";";

        final PreparedStatement statement = dbConnector.getPreparedStatement(query);
        try {
            return 1 == statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
