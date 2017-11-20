package com.niraj.searching;


/**
 * Pre-conditions for finding the number of rotations in a circular array :
 * 1. The array must be completely sorted
 * 2. There shouldn't be any duplicate elements in the array
 * 3. Number of rotations is determined by the distance of the smallest element in the array from 0th index
 */
public class BinarySearchForCircularArray {

    private int totalRotationsOfCircularArray(int[] array, int startIndex, int endIndex) {

        if (startIndex <= endIndex) {

            if (array[startIndex] <= array[endIndex]) {
                return startIndex;
            }
            int midIndex = startIndex + (endIndex-startIndex)/2;
            int previousIndex = (midIndex + array.length -1)%array.length;
            int nextIndex = (midIndex+1)%array.length;

            if (array[midIndex] <= array[previousIndex] && array[midIndex] <= array[nextIndex]) {
                return midIndex;
            }
            else if(array[midIndex] <= array[endIndex]) {
                return totalRotationsOfCircularArray(array, startIndex, midIndex-1);
            } else if (array[midIndex] >= array[startIndex]) {
                return totalRotationsOfCircularArray(array, midIndex+1, endIndex);
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        BinarySearchForCircularArray bSearch = new BinarySearchForCircularArray();

        int[] array = new int[] {45,56,72,78,88,91,3,8,17,25,38};

        System.out.println("Number of times the array is rotated : "+bSearch.totalRotationsOfCircularArray(array, 0 , array.length-1));
    }
}
