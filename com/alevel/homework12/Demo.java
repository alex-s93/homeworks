package com.alevel.homework12;

import java.io.*;
import java.util.Scanner;

public class Demo {
    public static String read(String path) throws IOException {
//открываем файл по пути
        BufferedReader reader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();
        String currentString;
//построчно считываем файл
        while ((currentString = reader.readLine()) != null) {
            stringBuilder.append(currentString);
            stringBuilder.append("\n");
        }
//закрываем файл
        reader.close();
//возвращаем вычитанный текст в строке
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(read("/Users/qa/test.txt"));
    }
}