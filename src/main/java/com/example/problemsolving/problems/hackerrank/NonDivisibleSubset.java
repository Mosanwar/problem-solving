package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class NonDivisibleSubset {
    public static void main(String[] args) {
//        System.out.println(nonDivisibleSubset(5,
//                                              List.of(770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493)));
        //770528134, 663501748, 384261537, 800309024, 101262949
        //663501748, 800309024, 101262949, 46058493
        //384261537, 800309024, 538539662, 101262949, 557792122
        //800309024, 538539662, 101262949, 557792122
        //103668401, 538539662, 385488901, 557792122, 46058493

        System.out.println(nonDivisibleSubset(3, List.of(1, 7, 2, 4)));
    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        int[] remainderArr = new int[k];

        for (Integer each : s) {
            remainderArr[each % k]++;
        }

        int zeroRemainder = remainderArr[0];
        int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;

        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i)
                maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
            else
                maxNumberOfDivisibleSet ++;
        }

        return maxNumberOfDivisibleSet;
    }
}
