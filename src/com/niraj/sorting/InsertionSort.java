package com.niraj.sorting;

import java.util.Random;


/**
 * Insertion sort algorithm has a running time complexity of O(n^2) during worst case.
 */
public class InsertionSort {

    private int[] populateArray() {

        int[] array = new int[10];
        Random rNum = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = rNum.nextInt(175);
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
     * Insertion sort algorithm is a stable algorithm if we keep the comparision of array[j] > current as written below.
     * Stable algorithms ensure that equal values are not shifted from their order of occurrence during sorting. In this
     * case, if we would have used '>=' instead of '>' for comparision, algorithm would behave as unstable as equal values
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
        int[] input = is.populateArray();
        is.displayArray(input);
        is.doInsertionSortingFromRight(input);
        System.out.println("\nArray after sorting ==========>");
        is.displayArray(input);
    }
}
