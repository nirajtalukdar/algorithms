package com.niraj.searching;

public class BinarySearchDuplicateCount {


    private  int result = -1;

    private int doBinarySearch(int[] array, int n, boolean isFirstCount, int startIndex, int endIndex) {

        if (startIndex<=endIndex) {

            int midIndex = startIndex + (endIndex-startIndex)/2;

            if (array[midIndex] == n) {
                result = midIndex;
                if (isFirstCount) {

                    return doBinarySearch(array, n, isFirstCount, startIndex, midIndex-1);
                } else {

                    return doBinarySearch(array, n, isFirstCount, midIndex+1, endIndex);
                }
            } else if (array[midIndex] > n) {

                return doBinarySearch(array, n, isFirstCount, startIndex, midIndex-1);
            } else {

                return doBinarySearch(array, n, isFirstCount, midIndex+1, endIndex);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        BinarySearchDuplicateCount bSearch = new BinarySearchDuplicateCount();

        int[] array = new int[] {3,12,17,22,37,37,37,49,55,63,75,75,89};

        int lastOccurrence = bSearch.doBinarySearch(array, 75, false, 0, array.length-1);
        System.out.println("Found last occurrence at index : "+lastOccurrence);
        int firstOccurrence = bSearch.doBinarySearch(array, 75, true, 0, array.length-1);
        System.out.println("Found first occurrence at index : "+firstOccurrence);
        int count = (lastOccurrence-firstOccurrence)+1;
        System.out.println("Total count : "+count);
    }
}
