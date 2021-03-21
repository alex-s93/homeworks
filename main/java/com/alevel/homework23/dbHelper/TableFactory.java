package com.alevel.homework23.dbHelper;

public class TableFactory {
    private static final String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS users (user_id int AUTO_INCREMENT PRIMARY KEY, " +
            "first_name varchar(55) NOT NULL, " +
            "last_name varchar(55) NOT NULL, " +
            "address varchar(255) NOT NULL, " +
            "birthday date, " +
            "email varchar(55) NOT NULL " +
            ");";

    private static final String CREATE_CATEGORY_TABLE = "CREATE TABLE IF NOT EXISTS categories (category_id int AUTO_INCREMENT PRIMARY KEY, " +
            "name varchar(55) NOT NULL" +
            ");";

    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS products (product_id int AUTO_INCREMENT PRIMARY KEY, " +
            "name varchar(55) NOT NULL, " +
            "price varchar(55) NOT NULL, " +
            "category_id int NOT NULL, " +
            "FOREIGN KEY (category_id) REFERENCES categories (category_id)" +
            ");";

    private static final String CREATE_ORDER_TABLE = "CREATE TABLE IF NOT EXISTS orders (order_id int AUTO_INCREMENT PRIMARY KEY, " +
            "product_id int NOT NULL, " +
            "user_id int NOT NULL, " +
            "count int NOT NULL, " +
            "status varchar(25) NOT NULL, " +
            "order_date timestamp NOT NULL, " +
            "FOREIGN KEY (product_id) REFERENCES products (product_id), " +
            "FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE" +
            ");";

    public static void createUserTable(DBConnector dbConnector) {
        dbConnector.executeUpdate(CREATE_USER_TABLE);
    }

    public static void createCategoryTable(DBConnector dbConnector) {
        dbConnector.executeUpdate(CREATE_CATEGORY_TABLE);
    }

    public static void createProductTable(DBConnector dbConnector) {
        dbConnector.executeUpdate(CREATE_PRODUCT_TABLE);
    }

    public static void createOrderTable(DBConnector dbConnector) {
        dbConnector.executeUpdate(CREATE_ORDER_TABLE);
    }
}
