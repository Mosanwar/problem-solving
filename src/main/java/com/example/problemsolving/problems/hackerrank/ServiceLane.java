package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ServiceLane {
//    https://www.hackerrank.com/challenges/service-lane/problem

    public static void main(String[] args) {
        System.out.println(serviceLane(8, List.of(1, 2, 2, 2, 1),
                List.of(List.of(2, 3), List.of(1, 4), List.of(2, 4), List.of(2, 4), List.of(2, 3))));
    }

    public static List<Integer> serviceLane(int n, List<Integer> width, List<List<Integer>> cases) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int minWidth;

        for (int i = 0; i < cases.size(); i++) {
            minWidth = Integer.MAX_VALUE;
            for (int j = cases.get(i).get(0); j <= cases.get(i).get(1); j++) {
                minWidth = Math.min(minWidth, width.get(j));
            }
            result.add(minWidth);
        }
        return result;
    }
}
