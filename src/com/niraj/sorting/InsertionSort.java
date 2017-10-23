package com.niraj.sorting;

import java.util.Random;

public class InsertionSort {

    private int[] populateArray() {

        int[] array = new int[10];

        for (int i = 0; i < 10; i++) {
            array[i] = new Random().nextInt(175);
        }

        return array;
    }

    private void doInsertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            for (int j = i; j > 0; j--) {

                if (array[j-1] > key) {
                    array[j] = array[j-1];
                    array[j-1] = key;
                } else {
                    array[j] = key;
                    break;
                }
            }
        }
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        InsertionSort is = new InsertionSort();
        System.out.println("Array before sorting ==========> ");
        int[] input = is.populateArray();
        is.displayArray(input);
        is.doInsertionSort(input);
        System.out.println("\nArray after sorting ==========>");
        is.displayArray(input);
    }
}
