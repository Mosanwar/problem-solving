package com.example.problemsolving.problems.hackerrank;

import java.util.*;

public class SherlockandtheValidString {
    /*
    * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
    * */

    public static void main(String[] args) {
        System.out.println(isValid("wwwwww"));
    }

    public static String isValid(String s) {
        // Write your code here
        if (s == null || s.isEmpty() || s.isBlank()) return "NO";
        if (s.length() <= 3) return "YES";
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        int maxDifferences = 0;
        int minDifferences = 0;
        List<Integer> values = new ArrayList<>(map.values());



        int min = values.stream().min(Comparator.comparing(Integer::valueOf)).get();
        int max = values.stream().max(Comparator.comparing(Integer::valueOf)).get();

        for (Integer value : values) {
            if (value == 1) {
                if (max != 1) {
                    maxDifferences += 1;
                }
                if (min != 1) {
                    minDifferences += 1;
                }
            } else {
                maxDifferences += max - value;
                minDifferences += value - min;
            }

            if (maxDifferences > 1 && minDifferences > 1) return "NO";
        }

        return "YES";
    }
}
