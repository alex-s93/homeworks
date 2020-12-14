package com.alevel.homework4;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a sequence of any 10 numbers (please use ',' as separator for non-integer numbers):");

        double[] elements = new double[5];
        for (int i = 0; i < 5; i++) {
            System.out.print((i + 1) + ": ");
            elements[i] = scanner.nextDouble();
        }

        System.out.println("Please tell me in what order the array should be sorted: asc or desc");
        scanner.skip("\\R"); // Next line will be skipped if remove this line
        String requiredOrder = scanner.nextLine();

        printResult(requiredOrder, elements);
    }

    static double[] getAscSortedArray(double... array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    double swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;
                }
            }
        }
        return array;
    }

    static double[] getDescSortedArray(double... array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] < array[j+1]) {
                    double swap = array[j];
                    array[j] = array[j+1];
                    array[j+1] = swap;
                }
            }
        }
        return array;
    }

    static void printResult(String requiredOrder, double[] array) {
        switch (requiredOrder) {
            case "asc":
                double[] ascSortedArray = getAscSortedArray(array);
                System.out.println("The sorted array in ASC order is: " + Arrays.toString(ascSortedArray));
                break;
            case "desc":
                double[] descSortedArray = getDescSortedArray(array);
                System.out.println("The sorted array in DESC order is: " + Arrays.toString(descSortedArray));
                break;
            default:
                System.out.println("Entered value (min or max) is not correct");
                break;
        }
    }
}
