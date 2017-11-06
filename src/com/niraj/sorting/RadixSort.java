package com.niraj.sorting;

public class RadixSort {

    private int findMaxNumber(int[] array) {

        int max = array[0];
        for (int i : array) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }

    private int findMaxNumDigits(int maxNum, int radix) {

        int length = 0;

        while (maxNum/radix > 0) {

            radix = radix*10;
            length++;
        }
        return length;
    }

    private void doRadixSort() {

    }
}
