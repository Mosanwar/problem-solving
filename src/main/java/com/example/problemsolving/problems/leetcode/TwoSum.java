package com.example.problemsolving.problems.leetcode;

import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3,2,4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indices = new HashMap<>();
        int comp;

        for (int i = 0; i < nums.length; i++) {
            comp = target - nums[i];
            if (indices.containsKey(comp)) {
                return new int[] {indices.get(comp), i};
            }

            indices.put(nums[i], i);
        }

        return null;
    }
}
