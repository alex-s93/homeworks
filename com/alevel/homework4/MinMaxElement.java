package com.alevel.homework4;

import java.util.Scanner;

public class MinMaxElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sequence of any 10 numbers (please use ',' as separator for non-integer numbers):");

        double[] elements = new double[10];
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ": ");
            elements[i] = scanner.nextDouble();
        }

        System.out.println("Please tell me what value you want to find: min or max");
        scanner.skip("\\R"); // Next line will be skipped if remove this line
        String requiredValue = scanner.nextLine();

        printResult(requiredValue, elements);
    }

    static double getMax(double... array) {
        double max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    static double getMin(double... array) {
        double min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    static void printResult(String requiredValue, double[] array) {
        switch (requiredValue) {
            case "max":
                double maxElement = getMax(array);
                System.out.println("The max element from the sequence is: " + maxElement);
                break;
            case "min":
                double minElement = getMin(array);
                System.out.println("The min element from the sequence is: " + minElement);
                break;
            default:
                System.out.println("Entered value (min or max) is not correct");
                break;
        }
    }
}
