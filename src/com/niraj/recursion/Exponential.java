package com.niraj.recursion;

import java.util.Random;

/**
 * For exponents, consider the below equation:
 *
 * even --> x^n/2 * x^n/2
 * odd --> x * x^n-1
 */
public class Exponential {

    private static long p = 0;
    private static long power(int x, int n) {

        if (n == 0)
            return 1;

        if (n%2 == 0) {
            p =  power(x, n/2);
            return  p*p;
        }
        else {
            return x*power(x, n-1);
        }
    }

    public static void main(String[] args) {

        Random rObj = new Random();
        int exponent = rObj.nextInt(10);
        System.out.println("Value of 2 to the power of : "+exponent+" : "+power(2, exponent));

    }
}
