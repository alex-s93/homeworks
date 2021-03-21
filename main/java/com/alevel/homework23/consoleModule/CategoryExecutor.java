package com.alevel.homework23.consoleModule;

import com.alevel.homework23.dao.CategoryDao;
import com.alevel.homework23.dbHelper.DBConnector;
import com.alevel.homework23.entities.Category;

import java.util.List;
import java.util.Scanner;

class CategoryExecutor {
    private static Scanner scanner = new Scanner(System.in);

    static void createCategory(DBConnector dbConnector) {
        System.out.println("Enter category name:");
        String name = scanner.nextLine();
        Category category = CategoryDao.buildCategory(name);
        CategoryDao.insertCategory(dbConnector, category);
    }

    static void updateCategory(DBConnector dbConnector) {
        System.out.println("Enter category name which you want to update:");
        String oldName = scanner.nextLine();
        if (CategoryDao.getCountOfCategoriesByName(dbConnector, oldName) == 0) {
            System.out.println("Category with this name is absent in the database. Try again");
            return;
        }

        System.out.println("Enter a new name for category:");
        String newName = scanner.nextLine();

        if (CategoryDao.updateCategory(dbConnector, oldName, newName)) {
            System.out.println("Category with name '" + oldName + "' was updated successfully!");
        } else {
            System.out.println("Something went wrong");
        }
    }

    static void showCategories(DBConnector dbConnector) {
        List<Category> categories = CategoryDao.getAll(dbConnector);
        if (categories.size() == 0) {
            System.out.println("There are no categories in the database");
            return;
        }
        for (Category category: categories) {
            System.out.println(category);
        }
    }
}
