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

    public static void main(String[] args) {

        Random rNumber = new Random();
        int low = 5;
        int high = 15;

        int n = rNumber.nextInt(high-low) + low;

        System.out.println("========= Using recursion =======");

        System.out.println("Fibonacci Sequence number in indexPosition "+n+" : "+ fibonacciUsingRecursion(n));

        System.out.println("========= Using loop =======");

        System.out.println("Fibonacci Sequence number in indexPosition "+n+" : "+fibonacciUsingLoop(n));
    }
}
