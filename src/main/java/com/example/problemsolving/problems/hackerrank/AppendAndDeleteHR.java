package com.example.problemsolving.problems.hackerrank;

public class AppendAndDeleteHR {

    public static void main(String[] args) {
        System.out.println(appendAndDelete("abcd", "abcdert", 10));
    }

    public static String appendAndDelete(String s, String t, int k) {
        if (Math.abs(s.length() - t.length()) > k) {
            return "No";
        }

        if (s.equals(t)){
            return "Yes";
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int mismatchIndex = 0;
        int minLength = Math.min(s.length(), t.length());
        for (int i = 0; i< minLength; i++){
            if (sChars[i] != tChars[i] || i == minLength -1) {
                mismatchIndex = i;
                break;
            }
        }

        int totalSteps = ((s.length()-mismatchIndex)+(t.length()-mismatchIndex));
        if (totalSteps > k || (k < s.length()+t.length() && (k-totalSteps) % 2 != 0)) {
            return "No";
        }

        return "Yes";
    }
}
