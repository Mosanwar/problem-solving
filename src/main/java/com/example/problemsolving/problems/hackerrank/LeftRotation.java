package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class LeftRotation {
    public static void main(String[] args) {
        System.out.println(rotateLeft(2, List.of(1, 2, 3, 4, 5)));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr){
        int cutoffIndex = d % arr.size();
        List<Integer> result = new ArrayList<>(arr.subList(cutoffIndex, arr.size()));
        result.addAll(arr.subList(0, cutoffIndex));

        return result;
    }


}
