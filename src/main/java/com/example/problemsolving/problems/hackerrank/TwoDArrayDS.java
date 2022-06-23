package com.example.problemsolving.problems.hackerrank;

import java.util.List;

// Hour glass problem
public class TwoDArrayDS {
    public static void main(String[] args) {

    }

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int result = Integer.MIN_VALUE;
        int temp;

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                temp =
                        arr.get(i).get(j) +
                        arr.get(i-1).get(j-1) +
                        arr.get(i-1).get(j) +
                        arr.get(i-1).get(j+1) +
                        arr.get(i+1).get(j-1) +
                        arr.get(i+1).get(j) +
                        arr.get(i+1).get(j+1);
                result = Math.max(result, temp);
            }
        }

        return result;
    }
}
