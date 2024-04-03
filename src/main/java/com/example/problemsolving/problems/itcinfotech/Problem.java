package com.example.problemsolving.problems.itcinfotech;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {

    public static void main(String[] args) {
        int[] records = new int[] { 1, 2, 0, 5, 0, 2, 4, 3, 3, 3 };
        System.out.println(Arrays.toString(simulate(records)));
    }

    public static int[] simulate(int[] entries) {
        int[] result = new int[entries.length];
        for (int i = 0; i <entries.length; i++) {
            if (i - 3 >= 0 && entries[i-3] >= entries[i]) {
                result[i] = 0;
            } else if (i + 4 < entries.length && entries[i + 4] >= entries[i]) {
                result[i] = 0;
            } else {
                result[i] = entries[i];
            }
        }

        return result;
    }

    public static Map<String, Integer> countWords (String str) {
        str = str.replaceAll("[^\\w\\s\\-_]", "");
        str = str.toLowerCase();
        List<String> words = List.of(str.split(" "));
        Map<String, Integer> result = new HashMap<>();
        for(String word: words) {
            result.merge(word, 1, Integer::sum);
        }

        return result;
    }


}
