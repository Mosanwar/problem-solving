package com.example.problemsolving.problems.leetcode;

import java.math.BigDecimal;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        boolean isNegative = false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            if (s.charAt(0) == '-') {
                isNegative = true;
            }
            s = s.substring(1);
        }

        StringBuilder numericString = new StringBuilder();

        while (!s.isEmpty() && Character.isDigit(s.charAt(0))) {
            numericString.append(s.charAt(0));
            s = s.substring(1);
        }

        if (numericString.length() == 0) {
            return 0;
        }

        BigDecimal l = isNegative? new BigDecimal(numericString.toString()).negate() : new BigDecimal(numericString.toString());

        if (l.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        } else if (l.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }

        return l.intValueExact();
    }
}
