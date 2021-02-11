package com.alevel.homework18.directory;

import java.io.File;
import java.util.Comparator;

public class FileComparator implements Comparator<File> {
    @Override
    public int compare(File fileLeft, File fileRight) {
        if (fileLeft.isFile() && fileRight.isDirectory()) {
            return 1;
        } else if (fileRight.isFile() && fileLeft.isDirectory()) {
            return -1;
        }
        return fileLeft.getName().compareTo(fileRight.getName());
    }
}

