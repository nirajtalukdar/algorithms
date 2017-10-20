package com.niraj.sorting;

import java.util.Random;

public class SelectionSort {

    private int[] populateArray() {

        int[] array = new int[25];

        for (int i = 0; i < 25; i++) {
            array[i] = new Random().nextInt(175);
        }

        return array;
    }

    private void sortArray(int[] input) {

        int min = 0;

        for (int i = 0; i < input.length-1; i++) {

            min = i;

            for (int j = i+1; j < input.length; j++) {
                if (input[j] < input[min])
                    min = j;
            }
            swapElement(input, i, min);
        }
    }

    private void swapElement(int[] array, int i, int min) {

        int temp = array[min];
        array[min] = array[i];
        array[i] = temp;
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        SelectionSort sSort = new SelectionSort();
        int[] inputArray = sSort.populateArray();
        System.out.println("Array before sorting ------->");
        sSort.displayArray(inputArray);
        sSort.sortArray(inputArray);
        System.out.println("\nArray after sorting ------->");
        sSort.displayArray(inputArray);
    }
}
