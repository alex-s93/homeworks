package com.alevel.homework27.consoleHelper;

import com.alevel.homework27.entity.Directory;

import java.io.File;
import java.util.Scanner;

class ConsoleExecutor {

    private static Scanner scanner = new Scanner(System.in);

    static void changeDirectory(Directory dir) {
        System.out.println("Select the directory in which you want to go:");
        System.out.println(dir.getExistsDirs());
        String dirName = scanner.nextLine();
        dir.setPath(dirName);
    }

    static void showDirTreeByName() {
        System.out.println("Enter the full path of the catalog, the tree of which you want to see");
        String dirName = scanner.nextLine();
        if (new File(dirName).exists()) {
            Directory dir = new Directory(dirName);
            String string = "{"+dir.toString()+"}";
            printTree(string);
        } else {
            System.out.println("This dir does not exist");
        }
    }

    static void showCurrentDirTree(Directory dir) {
        String string = "{"+dir.toString()+"}";
        printTree(string);
    }

    static void printCurrentDir(Directory dir) {
        System.out.println(dir.getPath());
    }

    private static String makeSpace(int a) {
        return "   ".repeat(Math.max(0, a));
    }

    private static void printTree(String string) {
        int space = 0;
        String s = string.trim();
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String a = String.valueOf(s.charAt(i));
            switch (a) {
                case "{":
                    space++;
                    a += "\n" + makeSpace(space);
                    break;
                case "}":
                    space--;
                    a = "\n" + makeSpace(space) + a;
                    break;
                case ",":
                    a += "\n" + makeSpace(space);
                    break;
            }
            newString.append(a);
        }
        System.out.println(newString);
    }

    static void createDir(Directory dir) {
        System.out.println("Enter the name of new directory:");
        String dirName = scanner.nextLine();
        dir.createDir(dirName);
    }

    static void createFile(Directory dir) {
        System.out.println("Enter the name of new file:");
        String fileName = scanner.nextLine();
        dir.createFile(fileName);
    }
}
