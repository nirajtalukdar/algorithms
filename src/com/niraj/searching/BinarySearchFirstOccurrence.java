package com.niraj.searching;

public class BinarySearchFirstOccurrence {

    int index = -1;

    private int findFirstOccurrence(int[] array, int n, int startIndex, int endIndex) {

        if (startIndex <= endIndex) {

            int midIndex = startIndex + (endIndex-startIndex)/2;
            if(array[midIndex] == n) {
                index = midIndex;
                return findFirstOccurrence(array, n, startIndex, midIndex-1);
            } else if (array[midIndex] > n) {

                return findFirstOccurrence(array, n, startIndex, midIndex-1);
            } else {

                return findFirstOccurrence(array, n, midIndex+1, endIndex);
            }
        }

        return  index;
    }

    public static void main(String[] args) {

        BinarySearchFirstOccurrence bSearch = new BinarySearchFirstOccurrence();
        int[] array = new int[] {3,12,17,22,37,37,37,49,55,63,75,75,89};

        int x = bSearch.findFirstOccurrence(array, 37, 0, array.length-1);
        System.out.println("Found first occurrence at index : "+x);
    }
}
