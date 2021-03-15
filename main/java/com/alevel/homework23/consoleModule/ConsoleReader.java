package com.alevel.homework23.consoleModule;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader {
    private static Scanner scanner = new Scanner(System.in);

    public static String getAction() {
        System.out.println("Please select action for performing:");
        printAvailableCommands();

        String action = scanner.nextLine();
        if (getAvailableCommands().contains(action)) {
            return action;
        } else {
            throw new RuntimeException("Impossible to perform the entered action.");
        }
    }

    static void printAvailableCommands() {
        System.out.println(getAvailableCommands());
    }

    static List<String> getAvailableCommands() {
        List<String> commands = new ArrayList<>();
        Field[] fields = ConsoleActions.class.getDeclaredFields();

        for (Field field : fields) {
            try {
                commands.add((String) field.get(field.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return commands;
    }
}
