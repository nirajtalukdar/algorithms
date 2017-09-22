package com.niraj.recursion;

import java.util.Random;

/**
 * Method to find the factorial of a random number between 5 & 15 using recursion and for loop
 * @author niraj
 */
public class Factorial {

    public static void main(String[] args) {

        Random rNumber = new Random();
        int low = 5;
        int high = 15;

        int n = rNumber.nextInt(high-low) + low;

        System.out.println("========= Using recursion =======");

        System.out.println("Factorial of "+n+" : "+ findFactorialUsingRecursion(n));

        System.out.println("========= Using loop =======");

        System.out.println("Factorial of "+n+" : "+findFactorialUsingLoop(n));
    }

    private static long findFactorialUsingRecursion(long n) {

        if (n == 0)
            return 1;
        return n* findFactorialUsingRecursion(n-1);
    }

    private static long findFactorialUsingLoop(int n) {

        long product = 1;

        for (int i = n; i > 0; i--) {
            product = product * i;
        }

        return product;
    }

}
