package com.alevel.homework20.task4.helpers;

import java.io.File;
import java.util.*;

public class FileHelper {
    private static List<File> javaFiles = new LinkedList<>();

    public static LinkedList<File> createFileList(File file) {
        return new LinkedList<>(Arrays.asList(file.listFiles()));
    }

    public static List<File> explore(List<File> files) {
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
