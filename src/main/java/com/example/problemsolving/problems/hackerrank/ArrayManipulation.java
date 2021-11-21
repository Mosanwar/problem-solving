package com.example.problemsolving.problems.hackerrank;

import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {

    public static void main(String[] args) {
        System.out.println(arrayManipulation2(10, List.of(List.of(1,5,3), List.of(4,8,7), List.of(6,9,1))));
        System.out.println(arrayManipulation2(5, List.of(List.of(1,2,100), List.of(2,5,100), List.of(3,4,100))));
    }

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        long result = 0;

        long[] arr = new long[n];
        Arrays.fill(arr, 0);

        for (List<Integer> query : queries) {
            int start = query.get(0);
            int end = query.get(1);
            int factor = query.get(2);
            for (int j = start; j <= end; j++) {
                arr[j-1] = arr[j-1] + factor;
                result = Math.max(result, arr[j-1]);
            }
        }

        return result;
    }

    public static long arrayManipulation2(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        Arrays.fill(arr, 0);

        for (List<Integer> query : queries) {
            int start = query.get(0);
            int end = query.get(1);
            int factor = query.get(2);
            arr[start - 1] += factor;
            if (end < n) {
                arr[end] -= factor;
            }
        }
        long currentValue = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            currentValue += arr[i];
            max = Math.max(max, currentValue);
        }

        return max;
    }
}
