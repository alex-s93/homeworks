package com.alevel.homework15.page40;

import java.util.ArrayList;
import java.util.List;

public class Quiz {


    public static void main(String[] args) {
        System.out.println(wildcardsTest(new ArrayList<>()));
    }


    public static Object wildcardsTest(List<? super Integer> numbers) {
        numbers.add(10);
        return numbers.get(0);
    }
}

