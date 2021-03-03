package com.alevel.homework20.task4;
import com.alevel.homework20.task2.FieldInitialization;
import com.alevel.homework20.task4.helpers.ClassHelper;
import com.alevel.homework20.task4.helpers.FileHelper;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;


public class ScanClasses {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        File dir = new File("src");

        LinkedList<File> files = FileHelper.createFileList(dir);
        List<File> javaFiles = FileHelper.explore(files);

        Method initMethod = ClassHelper.getInitMethod(javaFiles);
        Map<String, Object> objects = ClassHelper.getListOfInitializedClasses(javaFiles);

        invokeMethodForObjects(initMethod, objects);

        initializeFieldWithAnnotationValue(objects);
    }

    private static void invokeMethodForObjects(Method method, Map<String, Object> objects) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Map.Entry<String, Object> entry : objects.entrySet()) {
            method.invoke(method.getDeclaringClass().getConstructor().newInstance(), entry.getValue());
        }
    }

    private static void initializeFieldWithAnnotationValue(Map<String, Object> objects) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for (Map.Entry<String, Object> entry : objects.entrySet()) {
            FieldInitialization.initializeFields(entry.getValue().getClass());
        }
    }


}
