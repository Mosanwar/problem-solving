package com.example.problemsolving.problems.hackerrank;

import java.util.stream.IntStream;

public class DownToZeroII {
    public static void main(String[] args) {
        System.out.println(downToZero(10));
    }

    static int[] arr = IntStream.iterate(0, n -> n + 1).limit(1000001).toArray();

    static {
        for (int i = 2; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], 1 + arr[i - 1]);

            for (int j = 2; j * j <= i ; j++) {
                if (i % j == 0) {
                    arr[i] = Math.min(arr[i], arr[i/j]+1);
                }
            }
        }
    }

    public static int downToZero(int n) {
        return arr[n];
    }

}
