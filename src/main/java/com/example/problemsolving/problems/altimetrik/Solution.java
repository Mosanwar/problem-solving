package com.example.problemsolving.problems.altimetrik;

public class Solution {
    private static Solution solution1;
    private static Solution solution2;
    private static Solution solution3;
    private Solution(){}

    public static void main(String[] args) {
        String s1 = null;
        String s2 = "word";
//        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s1));
    }

    public Solution getInstance1() {
        if (solution1 == null) {
            solution1 = new Solution();
        }
        return solution1;
    }
}
/*
 SELECT salary FROM employee
 ORDER BY salary DESC LIMIT 1 OFFSET 1;
* */
