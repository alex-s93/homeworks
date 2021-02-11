package com.alevel.homework18.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

public class ConsoleUser {
    public static void main(String[] args) {
        TreeMap<String, String> consoleData = Helper.readFromConsole();

        String fileName = consoleData.get(Helper.FIELD_USER).replace(" ", "_").toUpperCase();
        File file = new File("src/resources/" + fileName + ".dat");

        String action = consoleData.get(Helper.FIELD_ACTION);
        switch (action) {
            case Helper.ACTION_CREATE:
                User user = new User(consoleData.get(Helper.FIELD_USER), consoleData.get(Helper.FIELD_EMAIL), consoleData.get(Helper.FIELD_PHONE));
                Helper.serialize(user, file);
            case Helper.ACTION_SHOW:
                try {
                    System.out.println(Helper.deserialization(file));
                } catch (FileNotFoundException e) {
                    System.out.println("User \"" + consoleData.get(Helper.FIELD_USER) + "\"  not found");
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
