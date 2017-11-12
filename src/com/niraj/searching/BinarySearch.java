package com.niraj.searching;

public class BinarySearch {


    private int doBinarySearch(int[] input, int n, int startIndex, int endIndex) {

        if(startIndex<=endIndex) {

            int midIndex = startIndex + (endIndex-startIndex)/2;
            if (input[midIndex] == n) {
                return midIndex;
            } else if (input[midIndex] > n) {
                return doBinarySearch(input, n, startIndex, midIndex-1);
            } else {
                return doBinarySearch(input, n, midIndex+1, endIndex);
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch bSearch = new BinarySearch();
        int[] input = new int[] {6, 11, 19, 38, 57, 77, 85, 92};

        int x = bSearch.doBinarySearch(input, 77, 0, input.length-1);
        System.out.println("Found number at index: "+x);
    }
}


