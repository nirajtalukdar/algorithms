package com.niraj.recursion;

import java.util.Random;

public class Factorial {

    public static void main(String[] args) {

        Random rNumber = new Random();

        int n = rNumber.nextInt(15-5) + 5;

        System.out.println("Factorial of "+n+" : "+findFactorial(n));
    }

    private static long findFactorial(long n) {

        if (n == 0)
            return 1;
        return n*findFactorial(n-1);
    }

}
