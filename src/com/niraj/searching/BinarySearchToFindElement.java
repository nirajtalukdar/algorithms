package com.niraj.searching;

public class BinarySearchToFindElement {

    private int findIndexOfElement(int[] array, int n, int startIndex, int endIndex) {

        if (startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex-startIndex)/2;

            if (array[midIndex] == n) {
                return midIndex;
            }
            if (array[midIndex] <= array[endIndex]) {
                if (n > array[midIndex] && n < array[endIndex]) {

                    return findIndexOfElement(array, n, midIndex+1, endIndex);
                } else {

                    return findIndexOfElement(array, n, startIndex, midIndex-1);
                }
            } else if (array[midIndex] >= array[startIndex]) {

                if (n >= array[startIndex] && n < array[midIndex]) {

                    return findIndexOfElement(array, n, startIndex, midIndex-1);
                } else {

                    return findIndexOfElement(array, n, midIndex+1, endIndex);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] array = new int[] {58,65,77,89,95,3,9,17,26,37,45};
        BinarySearchToFindElement bSearch = new BinarySearchToFindElement();
        int x = bSearch.findIndexOfElement(array, 37, 0, array.length-1);
        System.out.println("Position of element 37 is : "+x);
    }
}
