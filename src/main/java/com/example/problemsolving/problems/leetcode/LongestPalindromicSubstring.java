package com.example.problemsolving.problems.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aaaa"));
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

    public static String longestPalindrome2(String s) {
        if (s.length() < 2) return s;

        String maxStr = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i+1);

            if (odd.length() > maxStr.length()) maxStr = odd;
            if (even.length() > maxStr.length()) maxStr = even;
        }
        return maxStr;
    }

    private static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
}
