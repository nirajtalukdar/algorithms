package com.niraj.sorting;

import java.util.Random;

public class QuickSort {

    private void doQuickSort(int[] array, int startIndex, int endIndex) {

        if (startIndex < endIndex) {
            int partitionIndex = getPartitionIndex(array, startIndex, endIndex);
            doQuickSort(array, startIndex, partitionIndex-1);
            doQuickSort(array,partitionIndex+1, endIndex);
        }
    }

    private int getPartitionIndex(int[] array, int startIndex, int endIndex) {

        int pivot = array[endIndex];
        int partitionIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {

            if (array[i] <= pivot ) {

                swap(array, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(array, partitionIndex, endIndex);
        return partitionIndex;
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
        qSort.doQuickSort(array,0,array.length-1);
        System.out.println("\nArray after sorting ============>");
        qSort.displayArray(array);
    }
}
