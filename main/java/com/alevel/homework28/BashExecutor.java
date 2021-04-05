package com.alevel.homework28;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class BashExecutor {

    public static String getResult(File file) {
        String result = file.getName();
        if (result.endsWith(".java")) {
            try {
                Process process = Runtime.getRuntime().exec("/Users/qa/IdeaProjects/java_homeworks/src/main/java/com/alevel/homework28/bash_script " + file.getAbsolutePath());
                process.waitFor(3, TimeUnit.SECONDS);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                result += reader.readLine();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
