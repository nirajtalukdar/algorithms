package com.niraj.sorting;

import java.util.Random;

public class BubbleSort {

    private int[] populateArray() {

        int[] array = new int[25];

        for (int i = 0; i < 25; i++) {
            array[i] = new Random().nextInt(175);
        }

        return array;
    }

    private void doBubbleSort(int[] array) {

        for (int i = 0; i < array.length-1; i++) {

            boolean isSwapped = false;

            for (int j = 0; j < array.length - i; j++) {

                if(array[j] > array[j+1]) {
                    swapElement(array, j, j+1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }
    }

    private void swapElement(int[] array, int j, int i) {

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) {

        BubbleSort bs = new BubbleSort();
        System.out.println("Array before sorting ==========> ");
        int[] input = bs.populateArray();
        bs.displayArray(input);
        bs.doBubbleSort(input);
        System.out.println("\nArray after sorting ==========>");
        bs.displayArray(input);
    }
}
