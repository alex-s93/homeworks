package com.alevel.homework23.consoleModule;

import com.alevel.homework23.dao.CategoryDao;
import com.alevel.homework23.dao.ProductDao;
import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;
import com.alevel.homework23.entities.Product;

import java.util.*;

class ProductExecutor {
    private static Scanner scanner = new Scanner(System.in);


    static void createProduct(DBConnector dbConnector) {
        System.out.println("Enter a product name:");
        String name = scanner.nextLine();
        if (ProductDao.getCountOfProductsByName(dbConnector, name) > 0) {
            System.out.println("Product with this name already exists in the database. Try again.");
            return;
        }

        System.out.println("Enter a category name:");
        String categoryName = scanner.nextLine();
        Category category = CategoryDao.buildCategory(categoryName);
        CategoryDao.insertCategoryIfNotExist(dbConnector, category);
        category.setId(CategoryDao.getCategoryId(dbConnector, category));

        System.out.println("Enter a product price:");
        double price = Double.parseDouble(scanner.nextLine().replace(",", "."));

        Product product = ProductDao.buildProduct(category, name, price);
        ProductDao.insertProduct(dbConnector, product);
    }

    static void updateProduct(DBConnector dbConnector) {
        String[] productFields = {"name", "category name", "price"};

        System.out.println("Enter the name of the product you need to update:");
        String name = scanner.nextLine();
        if (ProductDao.getCountOfProductsByName(dbConnector, name) == 0) {
            System.out.println("Product with this name is absent in the database. Try again");
            return;
        }

        System.out.println("What information do you want to update? Please enter one or more parameters from the brackets" +
                " (" + Arrays.toString(productFields) + ").");

        Map<String, String> newValues = new HashMap<>();
        do {
            System.out.println("Field:");
            String field = scanner.nextLine().toLowerCase();
            if (!Arrays.asList(productFields).contains(field)) {
                System.out.println("The entered name of field does not correspond to any field in the database. Try again!");
                continue;
            }
            System.out.println("New value:");
            String newValue = scanner.nextLine();
            newValues.put(field, newValue);
            System.out.println("Is it all fields what you want to update?");
        } while (!scanner.nextLine().equals("yes"));
        if (newValues.size() == 0) {
            System.out.println("Nothing to update. Try again");
            return;
        }
        if (ProductDao.updateProduct(dbConnector, name, newValues)) {
            System.out.println("Product with name '" + name + "' was updated successfully!");
        } else {
            System.out.println("Something went wrong");
        }
    }

    static void showProducts(DBConnector dbConnector) {
        List<Product> products = ProductDao.getAll(dbConnector);
        if (products.size() == 0) {
            System.out.println("There are no products in the database");
            return;
        }
        for (Product product: products) {
            System.out.println(product);
        }
    }
}
