package com.alevel.homework5;

import java.util.Arrays;

public class TheSameNumbers {
    public static void main(String[] args) {
        int[] array = {5, 7, 8, 5, 7, 1, 5, 7, 8, 5, 7};
        int[][] verifiedNumbers = new int[array.length][2];

        int newIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (!contains(verifiedNumbers, array[i])) {
                verifiedNumbers[newIndex][0] = array[i];
                verifiedNumbers[newIndex][1]++;
                newIndex++;
            } else {
                int numberIndex = indexOfElement(verifiedNumbers, array[i]);
                verifiedNumbers[numberIndex][1]++;
            }
        }

        System.out.println(Arrays.deepToString(verifiedNumbers));

        int maxCount = verifiedNumbers[0][1];
        int popularNumber = verifiedNumbers[0][0];

        for (int i = 1; i < verifiedNumbers.length; i++) {
            if (verifiedNumbers[i][1] > maxCount) {
                maxCount = verifiedNumbers[i][1];
                popularNumber = verifiedNumbers[i][0];
            }
        }
        System.out.println("The most popular number is " + popularNumber + ", number of repetitions: " + maxCount);

    }

    static boolean contains(int[][] array, int value) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == value) {
                result = true;
                break;
            }
        }
        return result;
    }

    static int indexOfElement(int[][] array, int value) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][0] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

}
