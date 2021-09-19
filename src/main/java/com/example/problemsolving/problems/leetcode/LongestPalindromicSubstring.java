package com.example.problemsolving.problems.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ab"));
    }

    public static String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            int start = 0;
            int end = i;

            while (start < s.length() && end <= s.length()) {
                if (isPalindrome(s.substring(start, end))) {
                    return s.substring(start, end);
                }
                start++;
                end++;
            }
        }
        return s.charAt(0) + "";
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }
}
