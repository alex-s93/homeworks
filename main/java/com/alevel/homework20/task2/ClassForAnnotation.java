package com.alevel.homework20.task2;

public class ClassForAnnotation {
    @Value("123")
    private String id;
    @Value(value = "test name")
    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ClassForAnnotation{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
