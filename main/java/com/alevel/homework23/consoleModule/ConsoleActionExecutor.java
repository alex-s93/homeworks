package com.alevel.homework23.consoleModule;

import com.alevel.homework23.dbHelper.DBConnector;
import static com.alevel.homework23.consoleModule.Action.*;

public class ConsoleActionExecutor {


    public static void executeAction(DBConnector dbConnector) {
        Action action;
        do {
            action = Action.getActionName(ConsoleReader.getAction());
            switch (action) {
                case ACTION_CREATE_USER:
                    UserExecutor.createUser(dbConnector);
                    break;
                case ACTION_UPDATE_USER:
                    UserExecutor.updateUser(dbConnector);
                    break;
                case ACTION_DELETE_USER:
                    UserExecutor.deleteUser(dbConnector);
                    break;
                case ACTION_SHOW_USERS:
                    UserExecutor.showUsers(dbConnector);
                    break;
                case ACTION_CREATE_PRODUCT:
                    ProductExecutor.createProduct(dbConnector);
                    break;
                case ACTION_UPDATE_PRODUCT:
                    ProductExecutor.updateProduct(dbConnector);
                    break;
                case ACTION_SHOW_PRODUCTS:
                    ProductExecutor.showProducts(dbConnector);
                    break;
                case ACTION_CREATE_ORDER:
                    OrderExecutor.createOrder(dbConnector);
                    break;
                case ACTION_UPDATE_ORDER:
                    OrderExecutor.updateOrder(dbConnector);
                    break;
                case ACTION_SHOW_ORDERS:
                    OrderExecutor.showOrders(dbConnector);
                    break;
                case ACTION_CREATE_CATEGORY:
                    CategoryExecutor.createCategory(dbConnector);
                    break;
                case ACTION_UPDATE_CATEGORY:
                    CategoryExecutor.updateCategory(dbConnector);
                    break;
                case ACTION_SHOW_CATEGORIES:
                    CategoryExecutor.showCategories(dbConnector);
                    break;
            }
        } while(!action.equals(ACTION_FINISH_APPLICATION));
    }
}
