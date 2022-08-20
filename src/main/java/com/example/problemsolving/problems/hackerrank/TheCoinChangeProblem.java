package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class TheCoinChangeProblem {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        list.add(8L);
        list.add(3L);
        list.add(1L);
        list.add(2L);

        System.out.println(getWays(3, list));
    }

    public static long getWays(int n, List<Long> c) {
        long[] combinations = new long[n+1];
        combinations[0] = 1;
        for (Long coin : c) {
            for (int i = coin.intValue(); i < n+1; i++) {
                combinations[i] += combinations[(int) (i - coin)];
            }
        }
        return combinations[n];

    }
}