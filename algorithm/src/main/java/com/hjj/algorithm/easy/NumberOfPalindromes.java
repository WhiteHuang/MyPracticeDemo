package com.hjj.algorithm.easy;

import java.util.HashMap;

/**
 * 回文数
 * 例如：121,11211,1234567654321
 */
public class NumberOfPalindromes {
    public static void main(String[] args) {
        System.out.println( solution(10));
    }

    private static boolean solution(int number) {
        if (number == 0) {
            return true;
        }

        if (number < 0 || number % 10 == 0) {
            return false;
        }
        int reversed = 0;
        while (number > reversed) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return number == reversed || number == reversed / 10;
    }
}
