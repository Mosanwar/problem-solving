package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class KitestringAssessment {
    public static void main(String[] args) {
//        System.out.println(balancedSum(List.of(1,2,3,3)));
        System.out.println(segment(2, List.of(1)));
    }

    public static int balancedSum(List<Integer> arr) {
        if (arr.size() == 3) return 1;
        int leftIndex = 0;
        int leftSum = arr.get(leftIndex);
        int rightIndex = arr.size()-1;
        int rightSum = arr.get(rightIndex);
        for(int i = 0; i< arr.size(); i++) {
            if (leftSum > rightSum) {
                rightIndex--;
                rightSum += arr.get(rightIndex);
            } else if (rightSum > leftSum) {
                leftIndex++;
                leftSum += arr.get(leftIndex);
            } else {
                if ((rightIndex - leftIndex) == 2) {
                    return leftIndex+1;
                } else {
                    rightIndex--;
                    rightSum += arr.get(rightIndex);
                    leftIndex++;
                    leftSum += arr.get(leftIndex);
                }
            }
        }
        return 0;
    }


    public static int segment(int x, List<Integer> space) {
        int loopTimes = space.size() - x > 0 ? space.size() - x +1 : 1;
        int currentMinimum;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < x; i++) {
            if (i > space.size()-1) break;
            currentMinimum = Integer.MAX_VALUE;
            currentMinimum = Math.min(currentMinimum, space.get(i));
            max = Math.max(max, currentMinimum);
        }

        for (int i = 0; i < loopTimes; i++) {
            currentMinimum = Integer.MAX_VALUE;
            for (int j = i; j < i+x; j++) {
                if (j > space.size()-1) break;
                currentMinimum = Math.min(currentMinimum, space.get(j));
            }
            max = Math.max(max, currentMinimum);
        }

        return max;
    }
}
