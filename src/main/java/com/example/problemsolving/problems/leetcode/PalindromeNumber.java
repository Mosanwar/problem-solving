package com.example.problemsolving.problems.leetcode;

public class PalindromeNumber {
    /*
    Given an integer x, return true if x is palindrome integer.

    An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.

    Example 1:

    Input: x = 121
    Output: true
    Example 2:

    Input: x = -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    Example 3:

    Input: x = 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    Example 4:

    Input: x = -101
    Output: false
    * */

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        if (x <= 9) {
            return true;
        }

        String str = x + "";

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-1-i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber / 10;
    }
}
