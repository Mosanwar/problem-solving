package com.example.problemsolving.problems.amex;

import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {

    }

    public static LinkedList<Integer> reverseEveryGroup(LinkedList<Integer> list) {
        Collections.reverse(list);
        int idx = 0;
        while (idx < list.size()) {
            Collections.reverse(list.subList(0, 4));
        }
        return list;
    }
}
