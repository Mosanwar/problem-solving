package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SparseArrays {
    public static void main(String[] args) {
        System.out.println(matchingStrings2(List.of("aba", "baba", "aba", "xzxb"), List.of("aba", "xzxb", "ab")));
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            int count = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (queries.get(i).equals(strings.get(j))) {
                    count++;
                }
            }
            map.put(queries.get(i), count);
            result.add(count);
        }
        return result;
    }

    public static List<Integer> matchingStrings2(List<String> strings, List<String> queries) {
        Map<String, Integer> map = new HashMap<>();
        for (String str: strings) {
            map.merge(str, 1, Integer::sum);
        }

        List<Integer> result = new ArrayList<>();
        for (String q: queries) {
            result.add(map.getOrDefault(q, 0));
        }

        return result;
    }
}
