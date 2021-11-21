package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class ArrayPairs {
    public static void main(String[] args) {

    }

    public static long solve(List<Integer> arr) {
        // Write your code here
        long result = 0;
        long multiply;

        for (int i = 0; i <arr.size()-1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                long max = findMax(i, j, arr);
                multiply = arr.get(i) * arr.get(j);
                if (multiply <= max ) result++;
            }
        }
        return result;
    }

    private static long findMax(int i, int j, List<Integer> arr) {
        long max = 0;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, arr.get(k));
        }
        return max;
    }
}
