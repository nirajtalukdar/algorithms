package com.niraj.recursion;

import java.util.Random;

/**
 * Method which returns the Fibonacci sequence number at the given index position
 * This method displays ways to retrieve the Fibonacci sequence number in both recursion
 * and in loop.
 *
 * @author niraj
 */
public class Fibonacci {

    private static long[] index = null;

    /**
     * Time complexity of fibonacci Sequence using recursion is O(2^n)
     * @param indexPos int
     * @return long
     */
    public static long fibonacciUsingRecursion(int indexPos) {

        if(indexPos < 2)
            return  indexPos;

        return fibonacciUsingRecursion(indexPos-1) + fibonacciUsingRecursion(indexPos-2);
    }

    public static long fibonacciUsingLoop(int indexPos) {

        if (indexPos < 2)
            return indexPos;

        int F1 = 0;
        int F2 = 1;
        int F = 0;

        for (int i = 2; i <= indexPos; i++) {
             F = F1 + F2;
             F1 = F2;
             F2 = F;
        }
        return F;
    }

    /**
     * Process of memoization during recursion reduces the running time of the algorithm to a significant amount
     * Time complexity of fibonacci sequence using recursion with memoization is O(log n)
     * @param indexPos int
     * @return long
     */
    public static long fibonacciUsingMemoization(int indexPos) {

        if (index[indexPos] != -1)
            return index[indexPos];

        index[indexPos] = fibonacciUsingMemoization(indexPos - 1) + fibonacciUsingMemoization(indexPos - 2);
        return  index[indexPos];
    }

    public static void main(String[] args) {

        Random rNumber = new Random();
        int low = 5;
        int high = 15;

        int n = rNumber.nextInt(high-low) + low;

        System.out.println("========= Using loop =======");

        System.out.println("Fibonacci Sequence number in indexPosition "+n+" : "+fibonacciUsingLoop(n));

        System.out.println("========= Using recursion =======");

        System.out.println("Fibonacci Sequence number in indexPosition "+n+" : "+ fibonacciUsingRecursion(n));

        index = new long[n+1];

        index[0] = 0;
        index[1] = 1;
        for (int i = 2; i < index.length; i++) {
            index[i] = -1;
        }

        System.out.println("Fibonacci Sequence number in indexPosition "+n+" using memoization : "+fibonacciUsingMemoization(n));
    }
}
