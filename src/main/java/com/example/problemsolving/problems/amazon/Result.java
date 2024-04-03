package com.example.problemsolving.problems.amazon;

import java.util.*;

public class Result {

    /*
     * Complete the 'countGroups' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY related as parameter.
     */

    public static int countGroups(List<String> related) {
        // Write your code here
        boolean noChange = false;

        List<Set<Integer>> groups = new ArrayList<>();

        for (String str : related) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    set.add(i);
                }
            }
            groups.add(set);
        }
        while (!noChange) {
            noChange = true;
            int size = groups.size();
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    if (!Collections.disjoint(groups.get(i), groups.get(j))) {
                        groups.get(i).addAll(groups.get(j));
                        groups.remove(groups.get(j));
                        noChange = false;
                        break;
                    }
                }
                if (!noChange) {
                    break;
                }
            }
        }
        return groups.size();
    }
}