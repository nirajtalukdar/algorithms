package com.niraj.sorting;

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


    }
}
