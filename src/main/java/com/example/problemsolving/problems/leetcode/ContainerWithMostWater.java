package com.example.problemsolving.problems.leetcode;

/*
* https://leetcode.com/problems/container-with-most-water
* */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                result = Math.max(result, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return result;
    }

    public static int maxArea2(int[] height) {
        int result = 0, l = 0, r = height.length - 1;
        while (l < r) {
            result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
             if (height[l] < height[r]) l++;
             else r--;
        }
        return result;
    }
}
