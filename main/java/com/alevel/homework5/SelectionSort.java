package com.alevel.homework5;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {4,1,6,3,10,-4,-24,0,-10,2};

        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int minIndex = i;

            for (int j = i+1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
