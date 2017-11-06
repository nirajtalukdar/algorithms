package com.niraj.sorting;

import java.util.Random;


/**
 * Shell sort algorithm is an improvised version of insertion sort algorithm. The performance of insertion sort
 * worsens if it is applied on an array which is sorted in descending order. This is because every element has to
 * be shifted to the right. To avoid this problem, Donald Shell came up with the idea of sorting elements in a
 * calculated distance apart. This improves the running time complexity to an extent. The formula to derive at the
 * distance place a crucial role as different distances produces different time complexity against different input size.
 */
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
