package com.example.problemsolving.problems.hackerrank;

public class CamelCase {

    public static void main(String[] args) {
        System.out.println("Number of words: " + camelcase("zainabAbdulraheemIsmail"));
    }

    public static int camelcase(String s) {
        // Write your code here
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }

        int result = 1;

        for (char c: s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result++;
            }
        }

        return result;
    }
}
