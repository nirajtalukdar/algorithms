package com.niraj.sorting;

import java.util.Random;

/**
 * Characteristics of QuickSort algorithm
 * a) Worst Case : O(n^2)
 * b) Average Case: O(n log n)
 * c) Adaptable
 * d) In-place
 * e) Unstable
 */

public class QuickSort {

    private void doQuickSort(Random random, int[] array, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int partitionIndex = getRandomizedPartitionIndex(random, array, startIndex, endIndex);
            doQuickSort(random, array, startIndex, partitionIndex-1);
            doQuickSort(random, array,partitionIndex+1, endIndex);
        }
    }

    private int getPartitionIndex(int[] array, int startIndex, int endIndex) {

        int pivotIndex = endIndex;
        int partitionIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {

            if (array[i] <= array[pivotIndex] ) {

                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, pivotIndex);
        return partitionIndex;
    }

    /**
     * Randomized partitioning of array reduces the chances to hit the worst case of quick sort
     * algorithm to almost zero. This makes the quick sort algorithm adaptable with the running
     * time complexity at O(n log n) instead of O(n^2)
     */
    private int getRandomizedPartitionIndex(Random rNum, int[] array, int startIndex, int endIndex) {

        int pivotIndex = rNum.nextInt(endIndex-startIndex) + startIndex;
        swap(array, pivotIndex, endIndex);
        int partitionIndex = getPartitionIndex(array, startIndex, endIndex);
        return  partitionIndex;
    }

    private void swap(int[] array, int i, int pIndex) {

        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        int[] array = new int[20];
        Random rNum = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rNum.nextInt(75);
        }
        QuickSort qSort = new QuickSort();
        System.out.println("Array before sorting ============>");
        qSort.displayArray(array);
        qSort.doQuickSort(rNum, array,0,array.length-1);
        System.out.println("\nArray after sorting ============>");
        qSort.displayArray(array);
    }
}
