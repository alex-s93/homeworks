package com.alevel.homework27.entity;

import com.alevel.homework28.BashExecutor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Directory {
    private List<Directory> directories;
    private static boolean withStrings;
    private List<File> files;
    private List<String> filesWithStrings;
    private String path;

    public Directory(String path) {
        this.path = path;
        setDirsAndFiles();
    }

    public static void setWithStringsState(Boolean state) {
        withStrings = state;
    }

    public void createDir(String name) {
        File dir = new File(getPath() + '/' + name);
        if (!dir.exists()) {
            if (dir.mkdir()) {
                setDirsAndFiles();
                System.out.println("Dir with name '" + name + "' was created successfully.");
            } else {
                System.out.println("Something went wrong");
            }
        } else {
            System.out.println("Directory with this name already exists");
        }
    }

    public void createFile(String name) {
        File file = new File(getPath() + "/" + name);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    setDirsAndFiles();
                    System.out.println("File with name '" + name + "' was created successfully.");
                } else {
                    System.out.println("Something went wrong");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File with this name already exists");
        }
    }

    public void setDirsAndFiles() {
        File root = new File(getPath());
        List<Directory> dirs = new ArrayList<>();
        List<File> files = new ArrayList<>();
        List<String> filesWithStrings = new ArrayList<>();
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                dirs.add(new Directory(file.getAbsolutePath()));
            } else {
                files.add(file);
                filesWithStrings.add(BashExecutor.getResult(file));
            }
        }
        this.directories = dirs;
        this.files = files;
        this.filesWithStrings = filesWithStrings;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        if (getExistsDirs().contains(path)) {
            if (path.equals("..")) {
                List<String> paths = new ArrayList<>(Arrays.asList(getPath().split("/")));
                paths.remove(paths.size() - 1);
                this.path = String.join("/", paths);
            } else {
                this.path = getPath() + "/" + path;
            }
        } else {
            System.out.println("this directory does not exist");
            return;
        }
        setDirsAndFiles();
    }

    public List<String> getExistsDirs() {
        File dir = new File(getPath());
        List<String> dirs = new ArrayList<>();
        dirs.add("..");
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                dirs.add(file.getName());
            }
        }
        return dirs;
    }

    @Override
    public String toString() {
        String[] paths = path.split("/");
        String dirName = paths[paths.length - 1];
        StringBuilder result = new StringBuilder("'" + dirName + "':{");
        if (directories.size() != 0) {
            for (Directory dir : directories) {
                result.append(dir).append(",");
            }
        }
        if (withStrings) {
            if (filesWithStrings.size() != 0) {
                for (String string : filesWithStrings) {
                    result.append("'").append(string).append("'");
                    if (filesWithStrings.indexOf(string) != (filesWithStrings.size() - 1)) {
                        result.append(",");
                    }
                }
            }
        } else {
            if (files.size() != 0) {
                for (File file : files) {
                    result.append("'").append(file.getName()).append("'");
                    if (files.indexOf(file) != (files.size() - 1)) {
                        result.append(",");
                    }
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
