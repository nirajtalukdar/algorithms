package com.niraj.factorization;

import java.util.Random;

public class PrimeNumberList {

    public static void main(String[] args) {

        Random robj = new Random();
        int rNum = robj.nextInt(300);

        int[] primeList = new int[rNum+1];

        /*for (int i : primeList) {
            primeList[i] = 1;
        }*/

        for (int i = 0; i <= primeList.length-1; i++) {
            primeList[i] = 1;
        }
        primeList[0] = 0;
        primeList[1] = 0;

        System.out.println("List of prime number till "+rNum+"\n");

        displayPrimeNumber(getPrimeNumbers(rNum, primeList));
    }

    private static void displayPrimeNumber(int[] primeList) {

        for (int i = 0; i <= primeList.length-1; i++) {
            if (primeList[i] == 1)
                System.out.print(i+" ");
        }
    }

    private static int[] getPrimeNumbers(int rNum, int[] primeList) {

       primeList[2] = 1;
       double sqrt = Math.sqrt(rNum);

        for (int i = 2; i <= sqrt; i++) {

            if (primeList[i] == 1) {

                for (int j = 2; i*j <= rNum  ; j++) {

                    primeList[i*j] = 0;
                }
            }
        }

        return primeList;
    }
}
