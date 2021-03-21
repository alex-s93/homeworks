package com.alevel.homework23.consoleModule;

import com.alevel.homework23.dao.OrderDao;
import com.alevel.homework23.dao.ProductDao;
import com.alevel.homework23.dao.UserDao;
import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Order;
import com.alevel.homework23.entities.Product;
import com.alevel.homework23.entities.Status;
import com.alevel.homework23.entities.User;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

class OrderExecutor {
    private static Scanner scanner = new Scanner(System.in);

    static void createOrder(DBConnector dbConnector) {
        if (ProductDao.getAll(dbConnector).size() == 0) {
            System.out.println("There are no products in the database. Please create it before.");
            ProductExecutor.createProduct(dbConnector);
        }

        System.out.println("Choose and enter a product name from the list:");
        ProductExecutor.showProducts(dbConnector);
        Product product;
        String productName = scanner.nextLine();
        product = ProductDao.getProductByName(dbConnector, productName);

        System.out.println("Enter user's email");
        String email = scanner.nextLine();
        User user;
        if (UserDao.getCountOfUsersByEmail(dbConnector, email) == 0) {
            System.out.println("This user not exists in the database. Please create it before.");
            UserExecutor.createUser(dbConnector);
        }
        user = UserDao.getUserByEmail(dbConnector, email);

        System.out.println("Please chose and enter a status from the list:");
        System.out.println(Arrays.toString(Status.values()));
        String status = scanner.nextLine();
        if (!Arrays.toString(Status.values()).contains(status)) {
            System.out.println("Incorrect status. Try again.");
            return;
        }

        System.out.println("How many products you want to add to the order?");
        int count = Integer.parseInt(scanner.nextLine());

        Timestamp orderTime = Timestamp.valueOf(LocalDateTime.now());

        Order order = OrderDao.buildOrder(product, user, status, count, orderTime);
        OrderDao.insertOrder(dbConnector, order);
    }

    static void updateOrder(DBConnector dbConnector) {
        String[] orderFields = {"product name", "user email", "count", "status"};

        System.out.println("Enter the id of the order you need to update:");
        long orderId = Long.parseLong(scanner.nextLine());
        if (OrderDao.getCountOfOrdersById(dbConnector, orderId) == 0) {
            System.out.println("Order with this ID is absent in the database. Try again");
            return;
        }

        System.out.println("What information do you want to update? Please enter one or more parameters from the brackets" +
                " (" + Arrays.toString(orderFields) + ").");

        Map<String, String> newValues = new HashMap<>();
        do {
            System.out.println("Field:");
            String field = scanner.nextLine().toLowerCase();
            if (!Arrays.asList(orderFields).contains(field)) {
                System.out.println("The entered name of field does not correspond to any field in the database. Try again!");
                continue;
            }

            String newValue;
            if (field.equals("status")) {
                System.out.println("Please chose and enter a status from the list:");
                System.out.println(Arrays.toString(Status.values()));
                newValue = scanner.nextLine();
                if (!Arrays.toString(Status.values()).contains(newValue)) {
                    System.out.println("Incorrect status. Try again.");
                    return;
                }
            } else {
                System.out.println("New value:");
                newValue = scanner.nextLine();
                if (field.equals("user email") && UserDao.getCountOfUsersByEmail(dbConnector, newValue) == 0) {
                    System.out.println("This user does not exist in the database. Please create a user with such email or use an existing user.");
                    return;
                }
                if (field.equals("product name") && ProductDao.getCountOfProductsByName(dbConnector, newValue) == 0) {
                    System.out.println("This product does not exist in the database. Please create a product with this name or use the existing product in the database.");
                    return;
                }
            }
            newValues.put(field, newValue);
            System.out.println("Is it all fields what you want to update?");
        } while (!scanner.nextLine().equals("yes"));
        if (newValues.size() == 0) {
            System.out.println("Nothing to update. Try again");
            return;
        }
        if (OrderDao.updateOrder(dbConnector, orderId, newValues)) {
            System.out.println("Order with ID '" + orderId + "' was updated successfully!");
        } else {
            System.out.println("Something went wrong");
        }

    }

    static void showOrders(DBConnector dbConnector) {
        List<Order> orders = OrderDao.getAll(dbConnector);
        if (orders.size() == 0) {
            System.out.println("There are no orders in the database");
            return;
        }
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
