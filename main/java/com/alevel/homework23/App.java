package com.alevel.homework23;

import com.alevel.homework23.consoleModule.ConsoleActionExecutor;
import com.alevel.homework23.dbHelper.*;

public class App {
    public static void main(String[] args) {
        DBConnector dbConnector = new DBConnector();

        createRequiredTables(dbConnector);

        ConsoleActionExecutor.executeAction(dbConnector);
    }

    private static void createRequiredTables(DBConnector dbConnector) {
        TableFactory.createUserTable(dbConnector);
        TableFactory.createCategoryTable(dbConnector);
        TableFactory.createProductTable(dbConnector);
        TableFactory.createOrderTable(dbConnector);
    }
}
