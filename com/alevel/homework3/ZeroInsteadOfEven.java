package com.alevel.homework3;

public class ZeroInsteadOfEven {
    public static void main(String[] args) {
        // Create array
        int[] array = new int[2000];

        // fill array with numbers
        for (int i = 0; i < 2000; i++) {
            array[i] = (int) (Math.random() * 100 + 1); // (+ 1) for no 0 in the array
        }

        for (int i = 0; i < 2000; i++) {
            if (array[i] % 2 == 0) {
                array[i] = 0;
            }
        }
    }
}
