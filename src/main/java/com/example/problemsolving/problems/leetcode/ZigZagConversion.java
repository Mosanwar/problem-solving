package com.example.problemsolving.problems.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ZigZagConversion {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        int idx = 0;
        boolean flip = true;
        int count = 1;

        while (count <= s.length()) {
            arr[idx]+= s.charAt(count-1);
            if (idx == 0 || idx == numRows-1) {
                flip = !flip;
            }
            idx = flip ? idx-1 : idx+1;
            count++;

        }

        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
