package com.alevel.homework23.consoleModule;

import com.alevel.homework23.dbHelper.DBConnector;

public class ConsoleActionExecutor {

    public static void executeAction(DBConnector dbConnector, String action) {
        switch (action) {
            case ConsoleActions.ACTION_CREATE_USER:
                UserExecutor.createUser(dbConnector);
                break;
            case ConsoleActions.ACTION_UPDATE_USER:
                UserExecutor.updateUser(dbConnector);
                break;
            case ConsoleActions.ACTION_DELETE_USER:
                UserExecutor.deleteUser(dbConnector);
                break;
        }
    }




}
