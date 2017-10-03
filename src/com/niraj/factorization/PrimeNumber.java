package com.niraj.factorization;

import java.util.Random;

/**
 * Method to find whether a number is prime or not
 */
public class PrimeNumber {

    /**
     * Running time complexity of finding whether a number is prime through the square root method
     * is O(√n)
     * @param n int
     * @return boolean
     */
    private static boolean isNumberPrime(int n) {

        if (n == 2)
            return true;

        if (n <= 1 || n%2 == 0)
            return false;

        double sqrt = Math.sqrt(n);

        /**
         * Here we are starting from i=3 as any even number will already return as false
         * in the above condition. Also, every iteration will be i+2 to check only for the
         * odd numbers.
         */
        for (int i = 3; i <= sqrt; i+=2) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    /**
     * As per mathematical observations, all the factors of a number n is always lesser than
     * or equal to n/2.
     * @param n
     * @return
     */
    private static boolean isNumberPrimeUsingDivision(int n) {

        if (n == 2)
            return true;

        if (n <= 1 || n%2 == 0)
            return false;

        int limit = n/2;

        for (int i = 3; i <= limit; i+=2) {
            if (n%i == 0)
                return false;
        }
        return true;

    }

    public static void main(String[] args) {

        Random rNum = new Random();
        int n = rNum.nextInt(300);
        System.out.println("Is "+n+" a prime number : "+isNumberPrime(n));
        System.out.println("Is "+n+" a prime number using division: "+isNumberPrimeUsingDivision(n));
    }
}
