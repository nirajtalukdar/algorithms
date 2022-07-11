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
            //int partitionIndex = getRandomizedPartitionIndex(random, array, startIndex, endIndex);
            int partitionIndex = getPartitionIndexWithPivotAtBeginning(array, startIndex, endIndex);
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
     * Randomized partitioning of an array reduces the chances to hit the worst case of quick sort
     * algorithm to almost zero. This makes the quick sort algorithm adaptable with the running
     * time complexity at O(n log n) instead of O(n^2). Randomized partitioning will optimize the
     * algorithm in case the array is already sorted. It helps in swapping any random pivot index
     * value with the end index value of the array.
     */
    private int getRandomizedPartitionIndex(Random rNum, int[] array, int startIndex, int endIndex) {

        int pivotIndex = rNum.nextInt(endIndex-startIndex) + startIndex;
        /**
         * Below swapping is required to avoid running into a worst case if the array is
         * already sorted. Note that the call to getPartitionIndex will always happen with the
         * start and end index and not the pivot index. Only the values are swapped before calling.
         */
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

    public int getPartitionIndexWithPivotAtBeginning(int[] array, int startIndex, int endIndex) {

        int pivotValue = array[startIndex];
        int pIndex = endIndex;

        for (int i = endIndex; i > startIndex; i--) {
            if(array[i] > pivotValue) {
                swap(array, i, pIndex);
                pIndex--;
            }
        }
        swap(array, startIndex, pIndex);
        return pIndex;
    }

    public static void main(String[] args) {

        int[] array = new int[8];
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
