package com.niraj.miscellaneous;

import java.util.Scanner;

public class IntegerPalindrome {

    public static void main(String[] args) {

        System.out.println("Enter number to check if its palindrome :");
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Is "+number+" a palindrome? -> "+isNumberPalindrome(number));
    }

    private static boolean isNumberPalindrome(int number) {

        if (number == isReverse(number)) {
            return true;
        } else
            return false;
    }

    private static int isReverse(int number) {

        int reverse = 0;
        while (number != 0) {
            reverse = reverse*10 + number%10;
            number = number/10;
        }

        return reverse;
    }
}
