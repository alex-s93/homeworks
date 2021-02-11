package com.alevel.homework3.task2;

public class GeometricAverage {
    public static void main(String[] args) {
        int[] array = new int[400];

        for (int i = 0; i < 400; i++) {
            array[i] = (int) (Math.random() * 10 + 1); // (+ 1) for no 0 in the array
        }
        
        double multiplyingResult = 1;
        double rate = 0.0025;               // 1/400 = 0.0025
        for (int i = 0; i < 400; i++) {
            multiplyingResult = multiplyingResult * array[i];
        }

        double geometricAverage = Math.pow(multiplyingResult, rate);
        System.out.println("Geometric average of elements in the array is: " + geometricAverage);

    }
}
