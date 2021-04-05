package com.alevel.homework27.consoleHelper;

import com.alevel.homework27.entity.Directory;

import static com.alevel.homework27.consoleHelper.Action.*;


public class ConsoleHelper {
    public static void executeAction(Directory dir) {
        Action action;
        do {
            action = Action.getActionName(ConsoleReader.getAction());
            switch (action) {
                case ACTION_CREATE_DIR:
                    ConsoleExecutor.createDir(dir);
                    break;
                case ACTION_CREATE_FILE:
                    ConsoleExecutor.createFile(dir);
                    break;
                case ACTION_SHOW_CURRENT_TREE:
                    ConsoleExecutor.showCurrentDirTree(dir);
                    break;
                case ACTION_SHOW_TREE:
                    ConsoleExecutor.showDirTreeByName();
                    break;
                case ACTION_CURRENT_DIR:
                    ConsoleExecutor.printCurrentDir(dir);
                    break;
                case ACTION_CD:
                    ConsoleExecutor.changeDirectory(dir);
                    break;
                case ACTION_SHOW_TREE_WITH_STRINGS_IN_FILE:
                    ConsoleExecutor.showCurrentDirTreeWithAmountOfFileStrings(dir);
                    break;
            }
        } while (!action.equals(ACTION_FINISH_APPLICATION));
    }

}
