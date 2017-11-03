package com.niraj.sorting;

import java.util.Random;

public class ShellSort {

    private void doShellSorting(int[] array) {

        int gap = array.length/2;

        while (gap > 0) {

            for (int i = gap; i < array.length; i++) {

                int current = array[i];
                int j = i - gap;

                while (j >= 0 && array[j] > current) {
                    array[j + gap] = array[j];
                    j = j - gap;
                }
                array[j + gap] = current;
            }
            gap = gap/2;
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
        ShellSort sSort = new ShellSort();
        System.out.println("Array before sorting ============>");
        sSort.displayArray(array);
        sSort.doShellSorting(array);
        System.out.println("\nArray after sorting ============>");
        sSort.displayArray(array);
    }
}
