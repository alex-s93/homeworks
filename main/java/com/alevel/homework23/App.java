package com.alevel.homework23;

import com.alevel.homework23.dao.CategoryDao;
import com.alevel.homework23.dao.OrderDao;
import com.alevel.homework23.dao.ProductDao;
import com.alevel.homework23.dao.UserDao;
import com.alevel.homework23.dbHelper.*;
import com.alevel.homework23.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();

        TableFactory.createUserTable(dbConnector);
        TableFactory.createCategoryTable(dbConnector);
        TableFactory.createProductTable(dbConnector);
        TableFactory.createOrderTable(dbConnector);

        // USERS
        User userOne = buildUser("Alex", "Solodkov", LocalDate.now().minusYears(20), "Peremohy avenue 72");
        User userTwo = buildUser("Michael", "Pupkin", LocalDate.now().minusYears(22), "Heroev street 37");
        User userThree = buildUser("Daria", "Mishina", LocalDate.now().minusYears(17), "Landau avenue 22");
        User userFour = buildUser("Oleksandr", "Zavgorodniy", LocalDate.now().minusYears(31), "Independence avenue 98");

        UserDao.insertUser(dbConnector, userOne);
        UserDao.insertUser(dbConnector, userTwo);
        UserDao.insertUser(dbConnector, userThree);
        UserDao.insertUser(dbConnector, userFour);

        userOne.setId(UserDao.getUserId(dbConnector, userOne));
        userTwo.setId(UserDao.getUserId(dbConnector, userTwo));
        userThree.setId(UserDao.getUserId(dbConnector, userThree));
        userFour.setId(UserDao.getUserId(dbConnector, userFour));

        // CATEGORIES
        Category shoes = buildCategory("shoes");
        Category shirts = buildCategory("shirts");
        Category pants = buildCategory("pants");
        Category hats = buildCategory("hats");

        CategoryDao.insertCategory(dbConnector, shoes);
        CategoryDao.insertCategory(dbConnector, shirts);
        CategoryDao.insertCategory(dbConnector, pants);
        CategoryDao.insertCategory(dbConnector, hats);

        shoes.setId(CategoryDao.getCategoryId(dbConnector, shoes));
        shirts.setId(CategoryDao.getCategoryId(dbConnector, shirts));
        pants.setId(CategoryDao.getCategoryId(dbConnector, pants));
        hats.setId(CategoryDao.getCategoryId(dbConnector, hats));

        // PRODUCTS
        Product sneakers = buildProduct(shoes, "sneakers", 97.50);
        Product poloShirt = buildProduct(shirts, "Polo shirt", 29.60);
        Product jeans = buildProduct(pants, "Jeans", 59.25);
        Product cap = buildProduct(hats, "Cap", 17.75);

        ProductDao.insertProduct(dbConnector, sneakers);
        ProductDao.insertProduct(dbConnector, poloShirt);
        ProductDao.insertProduct(dbConnector, jeans);
        ProductDao.insertProduct(dbConnector, cap);

        sneakers.setId(ProductDao.getProductId(dbConnector, sneakers));
        poloShirt.setId(ProductDao.getProductId(dbConnector, poloShirt));
        jeans.setId(ProductDao.getProductId(dbConnector, jeans));
        cap.setId(ProductDao.getProductId(dbConnector, cap));

        // ORDERS
        Order orderOne = buildOrder(sneakers, userOne, Status.OPEN, 2, LocalDateTime.now());
        Order orderTwo = buildOrder(poloShirt, userTwo, Status.IN_PROGRESS, 4, LocalDateTime.now());
        Order orderThree = buildOrder(jeans, userThree, Status.CANCELED, 3, LocalDateTime.now());
        Order orderFour = buildOrder(cap, userFour, Status.COMPLETED, 1, LocalDateTime.now());

        OrderDao.insertOrder(dbConnector, orderOne);
        OrderDao.insertOrder(dbConnector, orderTwo);
        OrderDao.insertOrder(dbConnector, orderThree);
        OrderDao.insertOrder(dbConnector, orderFour);

        orderOne.setId(OrderDao.getOrderId(dbConnector, orderOne));
        orderTwo.setId(OrderDao.getOrderId(dbConnector, orderTwo));
        orderThree.setId(OrderDao.getOrderId(dbConnector, orderThree));
        orderFour.setId(OrderDao.getOrderId(dbConnector, orderFour));

        // CHECKING
        List<Category> categories = new LinkedList<>();
        categories.add(shoes);
        categories.add(shirts);
        categories.add(pants);
        categories.add(hats);
        System.out.println(categories);

        List<Product> products = new LinkedList<>();
        products.add(sneakers);
        products.add(poloShirt);
        products.add(jeans);
        products.add(cap);
        System.out.println(products);

        List<User> users = new LinkedList<>();
        users.add(userOne);
        users.add(userTwo);
        users.add(userThree);
        users.add(userFour);
        System.out.println(users);

        List<Order> orders = new LinkedList<>();
        orders.add(orderOne);
        orders.add(orderTwo);
        orders.add(orderThree);
        orders.add(orderFour);
        System.out.println(orders);

    }

    private static User buildUser(String firstName, String lastName, LocalDate birthday, String address) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBirthday(birthday);
        user.setAddress(address);
        return user;
    }

    private static Category buildCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category;
    }

    private static Product buildProduct(Category category, String name, double price) {
        Product product = new Product();
        product.setCategory(category);
        product.setName(name);
        product.setPrice(price);
        return product;
    }

    private static Order buildOrder(Product product, User user, Status status, int count, LocalDateTime orderDate) {
        Order order = new Order();
        order.setProduct(product);
        order.setUser(user);
        order.setStatus(status);
        order.setCount(count);
        order.setOrderDate(orderDate);
        return order;
    }
}
