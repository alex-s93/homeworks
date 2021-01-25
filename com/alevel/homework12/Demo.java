package com.alevel.homework12;

import java.io.*;

public class Demo {
    public static String read(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        String currentString;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            //построчно считываем файл
            while ((currentString = reader.readLine()) != null) {
                stringBuilder.append(currentString);
                stringBuilder.append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException message:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException message:" + e.getMessage());
        }
        //возвращаем вычитанный текст в строке
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(read("/Users/qa/test.txt"));
    }
}