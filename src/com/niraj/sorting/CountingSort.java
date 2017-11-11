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


    private void doCountingSort(int[] input, int max) {

        int[] temp = new int[10];
        int[] sortedArray = new int[input.length];
        int placeValue = 1;

        while (max/placeValue > 0) {

            for (int i = 0; i < temp.length; i++) {
                temp[i] = 0;
            }

            for (int i = 0; i < input.length; i++) {
                int lsd = (input[i]/placeValue)%10;
                temp[lsd]++;
            }

            for (int i = 1; i < temp.length; i++) {
                temp[i] = temp[i] + temp[i-1];
            }

            for (int i = input.length-1; i >= 0; i--) {
                int index = temp[(input[i]/placeValue)%10] -1;
                sortedArray[index] = input[i];
                temp[(input[i]/placeValue)%10]--;
            }

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

        int[] array = new int[15];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(75);
        }
        CountingSort cSort = new CountingSort();
        System.out.println("Array before sorting ============>");
        cSort.displayArray(array);
        cSort.doCountingSort(array, cSort.findMaxNumber(array));
        System.out.println("\nArray after sorting ============>");
        cSort.displayArray(array);
    }

}
