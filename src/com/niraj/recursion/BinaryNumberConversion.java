package com.niraj.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Method to represent a number in its binary format. Basically, the number is divided
 * by 2 (binary base is 2) and the remainder is stored as the bit. This can be carried
 * out recursively.
 */
public class BinaryNumberConversion {

    private static List<Integer> number = new ArrayList<>();
    private static int remainder= -1;

    private static List<Integer> getBaseConversion(int quotient, int base) {

        if (quotient > 0) {
            remainder = quotient%base;
            number.add(remainder);
            getBaseConversion(quotient/base, base);
        }
        return number;
    }

    public static void main(String[] args) {

        getBaseConversion(25, 2);

        for (int i = number.size() - 1; i >= 0; i--) {
            System.out.print(number.get(i) + " ");
        }
    }
}
