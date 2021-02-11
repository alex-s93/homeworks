package com.alevel.homework18.user;

import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

class Helper {
    static final String FIELD_USER = "user";
    static final String FIELD_EMAIL = "email";
    static final String FIELD_PHONE = "phone";
    static final String FIELD_ACTION = "action";
    static final String ACTION_CREATE = "create";
    static final String ACTION_SHOW = "show";

    static Object deserialization(File file) throws IOException {
        Object result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            result = ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    static void serialize(Object obj, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static TreeMap<String, String> readFromConsole() {
        Scanner consoleScanner = new Scanner(System.in);
        TreeMap<String, String> map = new TreeMap<>();

        while (consoleScanner.hasNextLine()) {
            String input = consoleScanner.nextLine().replace("\"", "");
            if (input.contains(FIELD_ACTION)) {
                String[] pairs = input.replace("create ", "").split(",");
                for (String values: pairs) {
                    String[] pair = values.split("=");
                    map.put(pair[0].trim(), pair[1].trim());
                }
                map.put(FIELD_ACTION, ACTION_CREATE);
                break;
            } else if (input.contains(ACTION_SHOW)) {
                String value = input.replace("show ", "");
                map.put(FIELD_USER, value);
                map.put(FIELD_ACTION, ACTION_SHOW);
                break;
            } else {
                throw new RuntimeException("Input does not contain existing command");
            }
        }
        return map;
    }
}
