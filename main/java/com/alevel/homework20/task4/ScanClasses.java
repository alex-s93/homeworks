package com.alevel.homework20.task4;

import com.alevel.homework20.task3.Service;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class ScanClasses {
    private static List<File> javaFiles = new LinkedList<>();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IOException {
        File dir = new File("src");
        LinkedList<File> files = createFileList(dir);
        List<File> javaFiles = explore(files);

        System.out.println(getListOfInitializedClasses(javaFiles));
    }

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

    private static <T> Map<String, T> getListOfInitializedClasses(List<File> files) throws ClassNotFoundException {
        Map<String, T> initializedClasses = new TreeMap<>();
        for (File file : files) {
            String fileName = getClassNameFromFile(file);
            Class<?> classObj = Class.forName(fileName);
            if (classObj.isAnnotationPresent(Service.class)) {
                T entity = (T) createInstance(classObj);
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

    private static LinkedList<File> createFileList(File file) {
        return new LinkedList<>(Arrays.asList(file.listFiles()));
    }

    private static List<File> explore(List<File> files) {
        for (File item : files) {
            if (item.isFile()) {
                if (item.getName().contains(".java")) {
                    javaFiles.add(item);
                }
            } else {
                explore(createFileList(item));
            }
        }
        return javaFiles;
    }
}
