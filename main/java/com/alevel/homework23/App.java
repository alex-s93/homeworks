package com.alevel.homework23;

import com.alevel.homework23.consoleModule.ConsoleActionExecutor;
import com.alevel.homework23.consoleModule.ConsoleReader;
import com.alevel.homework23.dao.*;
import com.alevel.homework23.dbHelper.*;
import com.alevel.homework23.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
//        createRequiredTables();
//
//        // USERS
//        User userOne = UserDao.buildUser("Alex", "Solodkov", LocalDate.parse("2020-12-11", DateTimeFormatter.ofPattern("yyyy-mm-dd")), "Peremohy avenue 72");
//        User userTwo = UserDao.buildUser("Michael", "Pupkin", LocalDate.now().minusYears(22), "Heroev street 37");
//        User userThree = UserDao.buildUser("Daria", "Mishina", LocalDate.now().minusYears(17), "Landau avenue 22");
//        User userFour = UserDao.buildUser("Oleksandr", "Zavgorodniy", LocalDate.now().minusYears(31), "Independence avenue 98");
//
//        UserDao.insertUser(dbConnector, userOne);
//        UserDao.insertUser(dbConnector, userTwo);
//        UserDao.insertUser(dbConnector, userThree);
//        UserDao.insertUser(dbConnector, userFour);
//
//        userOne.setId(UserDao.getUserId(dbConnector, userOne));
//        userTwo.setId(UserDao.getUserId(dbConnector, userTwo));
//        userThree.setId(UserDao.getUserId(dbConnector, userThree));
//        userFour.setId(UserDao.getUserId(dbConnector, userFour));
//
//        // CATEGORIES
//        Category shoes = CategoryDao.buildCategory("shoes");
//        Category shirts = CategoryDao.buildCategory("shirts");
//        Category pants = CategoryDao.buildCategory("pants");
//        Category hats = CategoryDao.buildCategory("hats");
//
//        CategoryDao.insertCategory(dbConnector, shoes);
//        CategoryDao.insertCategory(dbConnector, shirts);
//        CategoryDao.insertCategory(dbConnector, pants);
//        CategoryDao.insertCategory(dbConnector, hats);
//
//        shoes.setId(CategoryDao.getCategoryId(dbConnector, shoes));
//        shirts.setId(CategoryDao.getCategoryId(dbConnector, shirts));
//        pants.setId(CategoryDao.getCategoryId(dbConnector, pants));
//        hats.setId(CategoryDao.getCategoryId(dbConnector, hats));
//
//        // PRODUCTS
//        Product sneakers = ProductDao.buildProduct(shoes, "sneakers", 97.50);
//        Product poloShirt = ProductDao.buildProduct(shirts, "Polo shirt", 29.60);
//        Product jeans = ProductDao.buildProduct(pants, "Jeans", 59.25);
//        Product cap = ProductDao.buildProduct(hats, "Cap", 17.75);
//
//        ProductDao.insertProduct(dbConnector, sneakers);
//        ProductDao.insertProduct(dbConnector, poloShirt);
//        ProductDao.insertProduct(dbConnector, jeans);
//        ProductDao.insertProduct(dbConnector, cap);
//
//        sneakers.setId(ProductDao.getProductId(dbConnector, sneakers));
//        poloShirt.setId(ProductDao.getProductId(dbConnector, poloShirt));
//        jeans.setId(ProductDao.getProductId(dbConnector, jeans));
//        cap.setId(ProductDao.getProductId(dbConnector, cap));
//
//        // ORDERS
//        Order orderOne = OrderDao.buildOrder(sneakers, userOne, Status.OPEN, 2, LocalDateTime.now());
//        Order orderTwo = OrderDao.buildOrder(poloShirt, userTwo, Status.IN_PROGRESS, 4, LocalDateTime.now());
//        Order orderThree = OrderDao.buildOrder(jeans, userThree, Status.CANCELED, 3, LocalDateTime.now());
//        Order orderFour = OrderDao.buildOrder(cap, userFour, Status.COMPLETED, 1, LocalDateTime.now());
//
//        OrderDao.insertOrder(dbConnector, orderOne);
//        OrderDao.insertOrder(dbConnector, orderTwo);
//        OrderDao.insertOrder(dbConnector, orderThree);
//        OrderDao.insertOrder(dbConnector, orderFour);
//
//        orderOne.setId(OrderDao.getOrderId(dbConnector, orderOne));
//        orderTwo.setId(OrderDao.getOrderId(dbConnector, orderTwo));
//        orderThree.setId(OrderDao.getOrderId(dbConnector, orderThree));
//        orderFour.setId(OrderDao.getOrderId(dbConnector, orderFour));


//        System.out.println(ConsoleReader.getAction());
//        System.out.println(LocalDate.parse("2020-12-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
//        System.out.println(LocalDate.now().minusYears(22));



        DBConnector dbConnector = new DBConnector();

        String action = ConsoleReader.getAction();
        ConsoleActionExecutor.executeAction(dbConnector, action);

//        createRequiredTables(dbConnector);
//
//        User userOne = UserDao.buildUser("Alex", "Solodkov", LocalDate.parse("2020-12-11", DateTimeFormatter.ofPattern("yyyy-MM-dd")), "Peremohy avenue 72", "test2@test.com");
//        UserDao.insertUser(dbConnector, userOne);
//        userOne.setId(UserDao.getUserId(dbConnector, userOne));
//        int count = UserDao.getCountOfUsersByEmail(dbConnector, "test2@test.com");
//        System.out.println(count);
    }

    private static void createRequiredTables(DBConnector dbConnector) {
        TableFactory.createUserTable(dbConnector);
        TableFactory.createCategoryTable(dbConnector);
        TableFactory.createProductTable(dbConnector);
        TableFactory.createOrderTable(dbConnector);
    }
}
