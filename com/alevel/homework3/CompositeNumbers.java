package com.alevel.homework3;

public class CompositeNumbers {
    public static void main(String[] args) {
        // Create array
        int[] array = new int[1000];

        // fill array with numbers
        for (int i = 0; i < 1000; i++) {
            array[i] = (int) (Math.random() * 100 + 1); // (+ 1) for no 0 in the array
        }

        int compositeNumbers = 0;
        // check for prime number
        for (int i = 0; i < 1000; i++) {
            if (array[i] % 2 == 0 || array[i] % 3 == 0 || array[i] % 5 == 0 || array[i] % 7 == 0 || array[i] % 11 == 0) {
                compositeNumbers++;
            }
        }

        System.out.println("Number of composites is: " + compositeNumbers);
    }

}
