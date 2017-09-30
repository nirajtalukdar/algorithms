package com.niraj.factorization;

import java.util.Random;

public class PrimeNumber {

    private static boolean isNumberPrime(int n) {

        if (n == 2)
            return true;

        if (n <= 1 || n%2 == 0)
            return false;

        double sqrt = Math.sqrt(n);

        for (int i = 3; i <= sqrt; i+=2) {
            if (sqrt%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Random rNum = new Random();
        int n = rNum.nextInt(300);
        System.out.println("Is "+n+" a prime number : "+isNumberPrime(n));
    }
}
