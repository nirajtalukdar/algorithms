package com.niraj.searching;

public class BinarySearchFirstOccurrence {

    private int findFirstOccurrence(int[] array, int n, int startIndex, int endIndex) {

        int index = -1;

        return  index;
    }

    public static void main(String[] args) {

        BinarySearchFirstOccurrence bSearch = new BinarySearchFirstOccurrence();
        int[] array = new int[] {3,12,17,22,37,37,37,49,55,63,75,75,89};

        int x = bSearch.findFirstOccurrence(array, 77, 0, array.length-1);
        System.out.println("Find first occurrence at index : "+x);

    }
}
