package com.niraj.sorting;

import java.util.Random;

public class CountingSort {

    private int findMaxNumber(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {

            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private void doCountingSort(int[] input, int maxNumber) {

        int[] countArray = new int[maxNumber+1];

        for (int i : input) {
            countArray[i]++;
        }

        int sortedArrayIndex = 0;

        for (int i = 0; i < countArray.length; i++) {

            while (countArray[i] > 0) {
                input[sortedArrayIndex] = i;
                countArray[i]--;
                sortedArrayIndex++;
            }
        }
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        int[] array = new int[15];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(99);
        }
        CountingSort cSort = new CountingSort();
        System.out.println("Array before sorting ============>");
        cSort.displayArray(array);
        cSort.doCountingSort(array, cSort.findMaxNumber(array));
        System.out.println("\nArray after sorting ============>");
        cSort.displayArray(array);
    }
}
