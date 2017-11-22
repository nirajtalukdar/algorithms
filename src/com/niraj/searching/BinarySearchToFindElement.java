package com.niraj.searching;

public class BinarySearchToFindElement {

    private int findIndexOfElement(int[] array, int n, int startIndex, int endIndex) {

        return -1;
    }

    public static void main(String[] args) {

        int[] array = new int[] {58,65,77,89,95,3,9,17,26,37,45};
        BinarySearchToFindElement bSearch = new BinarySearchToFindElement();
        int x = bSearch.findIndexOfElement(array, 37, 0, array.length-1);
        System.out.println("Position of element 37 is : "+x);
    }
}
