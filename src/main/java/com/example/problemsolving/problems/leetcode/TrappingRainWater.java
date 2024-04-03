package com.example.problemsolving.problems.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TrappingRainWater {

    /*
    * https://leetcode.com/problems/trapping-rain-water/
    * */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uniqueNames(new String[]{"m", "m", "m"}, new String[]{"a", "h", "m"})));
    }


    public static String[] uniqueNames(String[] names1, String[] names2) {
        int setLength = Math.max(names1.length, names2.length);
        Set<String> set = new HashSet<>(setLength);
        for (int i = 0; i < setLength; i++) {
            if (i < names1.length) {
                set.add(names1[i]);
            }
            if (i < names2.length) {
                set.add(names2[i]);
            }
        }

        return set.toArray(new String[setLength]);
    }

}
