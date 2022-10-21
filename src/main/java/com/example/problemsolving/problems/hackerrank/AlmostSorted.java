package com.example.problemsolving.problems.hackerrank;


import java.util.Arrays;
import java.util.List;

/*
* https://www.hackerrank.com/challenges/almost-sorted/problem
* */

public class AlmostSorted {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{2, 3, 5, 4};
        List<Integer> list = Arrays.asList(arr);

        almostSorted(list);
    }

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        if (isSorted(arr)) {
            System.out.println("yes");
            return;
        }

        int i, j;
        for (i = 0; i < arr.size() - 1 && arr.get(i) < arr.get(i+1) ; ++i);
        for (j = arr.size() - 1; j > 0 && arr.get(j-1) < arr.get(j) ; --j);

        //try Swap
        swap(arr, i, j);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (i+1) + " " + (j+1));
            return;
        }

        //try revers
        int k = i+1, l = j+1;
        while (k<l) {
            swap(arr, k++, l++);
        }

        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + i+1 + " " + j+1);
            return;
        }

        System.out.println("no");
    }

    public static boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static void swap (List<Integer> list, int a, int b) {
        int temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }
}
