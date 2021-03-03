package com.alevel.homework20.task2;

import com.alevel.homework20.annotations.Value;

import java.lang.reflect.Field;

public class FieldInitialization {
    public static void main(String[] args) throws IllegalAccessException {
        ClassForAnnotation classForAnnotation = new ClassForAnnotation();

        // Before initializing
        System.out.println(classForAnnotation);
        initializeFields(classForAnnotation);
        // After initializing
        System.out.println(classForAnnotation);
    }

    public static <T> void initializeFields(T name) throws IllegalAccessException {
        Field[] fields = name.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Value.class)) {
                Value annotation = field.getAnnotation(Value.class);
                String value = annotation.value();

                field.setAccessible(true);
                field.set(name, value);
                field.setAccessible(false);
            }
        }
    }
}
