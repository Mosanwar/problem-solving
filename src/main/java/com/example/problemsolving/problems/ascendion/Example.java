package com.example.problemsolving.problems.ascendion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Example {
    public static void main(String[] args) {
        printDuplicate(new int[]{1, 2, 5, 1, 2, 2});
    }

    public static void printDuplicate(int[] nums) {
        Map<Integer, Set<Integer>> positions = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (positions.get(nums[i]) == null) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                positions.put(nums[i], set);
            } else {
                Set<Integer> set = positions.get(nums[i]);
                set.add(i);
                positions.put(nums[i], set);
            }
        }
        for(Map.Entry<Integer, Set<Integer>> entry: positions.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println("number: " + entry.getKey());
                System.out.println("Positions: " + entry.getValue());
            }
        }
    }
}
