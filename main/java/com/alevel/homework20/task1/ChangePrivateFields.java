package com.alevel.homework20.task1;

import java.lang.reflect.*;

public class ChangePrivateFields {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {
        A a = new A();
        Field[] fields = A.class.getDeclaredFields();
        // Before changing
        System.out.println(a.toString());
        for (Field field: fields) {
            String newValue = "changed field value with name \"" + field.getName() + "\"";
            changePrivateFieldValue(a, field, newValue);
        }
        // After changing
        System.out.println(a.toString());
    }

    static <T> void changePrivateFieldValue(T className, Field field, String value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(className, value);
        field.setAccessible(false);
    }
}
