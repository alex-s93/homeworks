package com.alevel.homework3.task2;

public class ArithmeticAverage {
    public static void main(String[] args) {
        // Create array
        int[] array = new int[400];

        // fill array with numbers
        for (int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random() * 100 + 1); // (+ 1) for no 0 in the array
        }

        // Get sum of elements
        int sum = 0;
        for (int i = 0; i < 400; i++) {
            sum = sum + array[i];
        }

        // calculate arithmetic average
        double arithmeticAverage = (double) sum / 400;
        System.out.println("Arithmetic average of elements in the array is: " + arithmeticAverage);
    }
}
