package com.example.problemsolving.problems.leetcode;
// https://leetcode.com/problems/3sum/description/

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
           int j = i + 1;
           int k = nums.length - 1;

           while (j < k) {
               if (nums[i] + nums[j] + nums[k] == 0) {
                   result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                   j++;
                   k--;
               } else if (nums[i] + nums[j] + nums[k] > 0) k--;
               else j++;
           }
        }

        return new ArrayList<>(result);
    }
}
