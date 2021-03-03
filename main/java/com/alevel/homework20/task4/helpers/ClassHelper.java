package com.alevel.homework20.task4.helpers;

import com.alevel.homework20.annotations.*;

import java.io.File;
import java.lang.reflect.*;
import java.util.*;

public class ClassHelper {
    private static <T> T createInstance(Class<T> className) {
        try {
            Constructor constructor = className.getConstructor();
            T entity = (T) constructor.newInstance();
            return entity;
        } catch (NoSuchMethodException e) {
            System.out.println("Error: No default constructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Error: Object can't be created");
        }
        return null;
    }

    public static Map<String, Object> getListOfInitializedClasses(List<File> files) throws ClassNotFoundException {
        Map<String, Object> initializedClasses = new TreeMap<>();
        for (File file : files) {
            String fileName = getClassNameFromFile(file);
            Class<?> classObj = Class.forName(fileName);
            if (classObj.isAnnotationPresent(Service.class)) {
                Object entity = createInstance(classObj);
                String className = classObj.getSimpleName();
                initializedClasses.put(className, entity);
            }

        }
        return initializedClasses;
    }

    private static String getClassNameFromFile(File file) {
        String projectPath = System.getProperty("user.dir") + "/";
        String projectStructurePath = "src/main/java/";

        return file.getAbsolutePath()
                .replace(projectPath, "")
                .replace(projectStructurePath, "")
                .replace(".java", "")
                .replace("/", ".");
    }

    public static Method getInitMethod(List<File> files) throws ClassNotFoundException {
        for (File file : files) {
            String fileName = getClassNameFromFile(file);
            Class<?> classObj = Class.forName(fileName);

            Method[] methods = classObj.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Init.class)) {
                    return method;
                }
            }
        }
        return null;
    }
}
