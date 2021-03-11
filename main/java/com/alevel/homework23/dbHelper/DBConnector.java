package com.alevel.homework23.dbHelper;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.alevel.homework23.dbHelper.ConnectionConstant.URL;
import static com.alevel.homework23.dbHelper.ConnectionConstant.USER;
import static com.alevel.homework23.dbHelper.ConnectionConstant.PASSWORD;

public class DBConnector implements Closeable {
    private final Connection connection;

    public DBConnector() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public PreparedStatement getPreparedStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            return connection.createStatement().executeQuery(query);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    public int executeUpdate(String query) {
        try {
            return connection.createStatement().executeUpdate(query);
        } catch (SQLException sqlException) {
            System.out.println(query);
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}

