package com.example.problemsolving.problems.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{1,1,1,0}, -100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        int sumOfClosest = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length-1;
            while (j < k) {
                int threeSum = nums[i] + nums[j] + nums[k];
                if (Math.abs(closest) > Math.abs(target - threeSum)) {
                    closest = target - threeSum;
                    sumOfClosest = threeSum;
                }
                if (threeSum > target) {
                    k--;
                } else if (threeSum < target) {
                    j++;
                } else {
                    return sumOfClosest;
                }
            }
        }
        return sumOfClosest;
    }
}
