package com.example.problemsolving.problems.leetcode;

//https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int idx = 0;
        boolean match = true;
        Character current = null;
        while (match) {
            for (String str: strs) {
                if (idx >= str.length() || (current != null && current != str.charAt(idx))) {
                    match = false;
                    break;
                }
                if (current == null) {
                    current = str.charAt(idx);
                }
            }
            if (match) {
                stringBuilder.append(current);
                current = null;
                idx++;
            }
        }
        return stringBuilder.toString();
    }
}
