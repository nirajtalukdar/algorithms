package com.niraj.sorting;

import java.util.Random;

public class MergeSort {

    private void doMergeSort(int[] array, int startIndex, int endIndex) {

        if (startIndex < endIndex) {

            int midIndex = (startIndex+endIndex)/2;
            doMergeSort(array, startIndex, midIndex);
            doMergeSort(array, midIndex+1, endIndex);
            doMerging(array, startIndex, midIndex, endIndex);
        }
    }

    private void doMerging(int[] array, int startIndex, int midIndex, int endIndex) {

        int leftStartIndex = startIndex;
        int rightStartIndex = midIndex + 1;
        int[] temp = new int[(endIndex - startIndex) + 1];
        int k = 0;

        while (leftStartIndex <= midIndex && rightStartIndex <= endIndex) {

            if (array[leftStartIndex] < array[rightStartIndex]) {

                temp[k] = array[leftStartIndex];
                leftStartIndex++;
            } else {
                temp[k] = array[rightStartIndex];
                rightStartIndex++;
            }
            k++;
        }

        while (leftStartIndex <= midIndex) {
            temp[k] = array[leftStartIndex];
            leftStartIndex++;
            k++;
        }

        while (rightStartIndex <= endIndex) {
            temp[k] = array[rightStartIndex];
            rightStartIndex++;
            k++;
        }

        k = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            array[i] = temp[k];
            k++;
        }
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
        MergeSort mSort = new MergeSort();
        System.out.println("Array before sorting ============>");
        mSort.displayArray(array);
        mSort.doMergeSort(array, 0, array.length-1);
        System.out.println("\nArray after sorting ============>");
        mSort.displayArray(array);
    }
}