package com.example.problemsolving.problems.leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse2(-123456));
    }

    public static int reverse(int x) {
        boolean negative = false;

        if (x < 0) {
            x *= -1;
            negative = true;
        }

        String s = x + "";
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        try {
            return negative ? Integer.parseInt(sb.toString()) * -1 : Integer.parseInt(sb.toString());
        } catch (Exception e) {
            return 0;
        }
    }

    public static int reverse2(int x) {

        long out = 0;
        while (x != 0) {
            out = out * 10 + x % 10;
            x /= 10;
        }

        if (out > Integer.MAX_VALUE || out < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) out;
    }
}
