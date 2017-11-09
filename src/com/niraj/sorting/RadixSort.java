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


    private int[] doRadixSort(int[] input, int max) {

        int placeValue = 1;

        int[] temp = new int[10];
        int[] sortedArray = new int[input.length];

        while (max/placeValue > 0) {

            for (int i = 0; i < temp.length; i++) {
                temp[i] = 0;
            }

            for (int i = 0; i < input.length; i++) {
                int index = (input[i]/placeValue) % 10;
                temp[index]++;
            }

            for (int i = 1; i < temp.length; i++) {
                temp[i] = temp[i] + temp[i-1];
            }

            for (int i = input.length -1; i >=0; i--) {

                int index = temp[(input[i]/placeValue)%10] -1;
                sortedArray[index] = input[i];
                temp[(input[i]/placeValue)%10]--;
            }

            placeValue = placeValue*10;
        }
        return sortedArray;
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        int[] array = new int[5];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(75);
        }
        RadixSort rSort = new RadixSort();
        System.out.println("Array before sorting ============>");
        rSort.displayArray(array);
        array = rSort.doRadixSort(array, rSort.findMaxNumber(array));
        System.out.println("\nArray after sorting ============>");
        rSort.displayArray(array);
    }
}
