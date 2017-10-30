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

        int leftStartIndex = startIndex;
        int rightStartIndex = midIndex+1;
        int[] temp = new int[(endIndex-startIndex)+1];
        int k = 0;

        while(leftStartIndex <= midIndex && rightStartIndex <= endIndex) {

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
    }
}
