package com.example.problemsolving.problems.confluent;

import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = List.of(2, 3, 4, 5, 6, 7, 10);
        System.out.println(Collections.binarySearch(list, 8));
    }
}