package com.niraj.sorting;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;


/**
 * Insertion sort algorithm has a running time complexity of O(n^2) during worst case.
 */
public class InsertionSort {

    private int[] populateArray(final int arraySize) {

        int[] array = new int[arraySize];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(arraySize*5);
        }
        return array;
    }

    /**
     * Another way of applying the insertion sorting logic
     */
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

    /**
     * Insertion sort algorithm is a stable algorithm if we keep the comparison of array[j] > current as written below.
     * Stable algorithms ensure that equal values are not shifted from their order of occurrence during sorting. In this
     * case, if we would have used '>=' instead of '>' for comparison, algorithm would behave as unstable as equal values
     * would have been shifted.
     */
    private void doInsertionSorting(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int current = array[i];
            int j = i-1;

            while (j>=0 && array[j] > current) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = current;
        }
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    /**
     * Insertion sort in reverse order iterating the array from right to left
     */
    private void doInsertionSortingFromRight(int[] array) {

        for (int i = array.length-1; i > -1 ; i--) {

            int current = array[i];

            int j = i+1;
            while (j<=array.length-1 && array[j] < current) {
                array[j-1] = array[j];
                j++;
            }
            array[j-1] = current;
        }
    }

    public static void main(String[] args) {

        InsertionSort is = new InsertionSort();
        System.out.println("Array before sorting ==========> ");
        int[] input = is.populateArray(8);
        is.displayArray(input);
        Instant start = Instant.now();
        is.doInsertionSorting(input);
        Instant end = Instant.now();
        System.out.println("\nArray after sorting ==========>");
        is.displayArray(input);
        System.out.println("\nTime taken (ms) : "+ Duration.between(start, end).toMillis());
    }
}
