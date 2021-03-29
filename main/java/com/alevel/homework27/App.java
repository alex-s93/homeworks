package com.alevel.homework27;

import com.alevel.homework27.consoleHelper.ConsoleHelper;
import com.alevel.homework27.entity.Directory;

public class App {

    public static void main(String[] args) {
        String rootPath = "/Users/qa/IdeaProjects/java_homeworks/src/main/java/com/alevel";

        Directory root = new Directory(rootPath);

        ConsoleHelper.executeAction(root);
    }
}
