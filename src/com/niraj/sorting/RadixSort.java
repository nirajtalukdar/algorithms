package com.niraj.sorting;

import java.util.Random;

public class RadixSort {

    private int findMaxNumber(int[] array) {

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    private void doRadixSort(int[] input, int max) {

        int placeValue = 1;

        int[] temp = new int[10];
        int[] sortedArray = new int[input.length];

        while (max/placeValue > 0) {

            /**
             * Reset the counter every time before you make one pass. This is required from the 2nd pass
             * onwards to avoid considering previous passes's count values.
             */
            for (int i = 0; i < temp.length; i++) {
                temp[i] = 0;
            }

            /**
             * Fetch the LSD and increment the index by one. Here the index is considered by the LSD retrieved.
             */
            for (int i = 0; i < input.length; i++) {
                int index = (input[i]/placeValue) % 10;
                temp[index]++;
            }

            /**
             * Sum of counts. Sum of current index with previous index count.
             */
            for (int i = 1; i < temp.length; i++) {
                temp[i] = temp[i] + temp[i-1];
            }

            for (int i = input.length -1; i >=0; i--) {

                int index = temp[(input[i]/placeValue)%10] -1;
                sortedArray[index] = input[i];
                temp[(input[i]/placeValue)%10]--;
            }

            /**
             * Copy the sorted numbers back to the input array
             */
            for (int i = 0; i < input.length; i++) {

                input[i] = sortedArray[i];
            }

            placeValue = placeValue*10;
        }
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        int[] array = new int[12];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(75);
        }
        RadixSort rSort = new RadixSort();
        System.out.println("Array before sorting ============>");
        rSort.displayArray(array);
        rSort.doRadixSort(array, rSort.findMaxNumber(array));
        System.out.println("\nArray after sorting ============>");
        rSort.displayArray(array);
    }
}
