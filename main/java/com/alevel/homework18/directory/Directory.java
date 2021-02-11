package com.alevel.homework18.directory;

import java.io.File;
import java.util.*;

public class Directory {
    public static void main(String[] args) {
        File project = new File("/Users/qa/IdeaProjects/java_homeworks/src/main");
        String prefix = "  ";

        LinkedList<File> files = createSortedFileList(project);

        explore(files, prefix);
    }

    private static LinkedList<File> createSortedFileList(File file) {
        LinkedList<File> files = new LinkedList<>(Arrays.asList(file.listFiles()));
        files.sort(new FileComparator());

        return files;
    }

    private static void explore(LinkedList<File> files, String prefix) {
        while (files.size() > 0) {
            File item = files.pollFirst();
            if (item.isFile()) {
                System.out.println(prefix + item.getName());
            } else {
                System.out.println(prefix + "*" + item.getName());
                files.addAll(createSortedFileList(item));
            }
        }
    }

//    private static void explore(List<File> files, String prefix) {
//        for (File item : files) {
//            if (item.isFile()) {
//                System.out.println(prefix + item.getName());
//            } else {
//                System.out.println(prefix + "*" + item.getName());
//                explore(createSortedFileList(item), prefix + "  ");
//            }
//        }
//    }
}