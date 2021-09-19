package com.example.problemsolving.problems.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
//        System.out.println(findMedianOf2Numbers(3, 4));
//        System.out.println(findMedianOf3Numbers(2, 3, 4));
//        System.out.println(findMedianOf4Numbers(2, 3, 4, 5));
//        System.out.println(findMedianOfSingle(new int[]{1,2,3,4,5,6,7,8,}));
        System.out.println("============================================================");
        System.out.println(findMedianSortedArrays(new int[]{1,5,6}, new int[] {2,3,4,7,8}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length < nums2.length? findMedianUtil(nums1, nums1.length, nums2, nums2.length) :
                findMedianUtil(nums2, nums2.length, nums1, nums1.length);
    }

    public static double findMedianOf2Numbers(int a, int b) {
        return (a+b) / 2.0;
    }

    public static int findMedianOf3Numbers(int a, int b, int c) {
        return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }

    public static double findMedianOf4Numbers(int a, int b, int c, int d) {
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        int min = Math.min(a, Math.min(b, Math.min(c, d)));

        return (a + b + c + d - max - min) / 2.0;
    }

    public static double findMedianOfSingle(int[] A) {
        if (A.length == 0) {
            return -1;
        }

        return A.length % 2 == 1 ? A[A.length/2] : (A[A.length/2] + A[A.length/2 - 1])/2.0;
    }

    public static double findMedianUtil (int[] A, int N, int[] B, int M) {
        if (N == 0) {
            return findMedianOfSingle(B);
        }

        if (N == 1) {
            if (M == 1) {
                return findMedianOf2Numbers(A[0], B[0]);
            }

            if (M % 2 == 1) {
                return findMedianOf2Numbers(B[M/2], findMedianOf3Numbers(B[M/2+1], B[M/2-1], A[0]));
            }

            return findMedianOf3Numbers(B[M/2], B[M/2-1], A[0]);
        }

        else if (N == 2) {
            if (M == 2) {
                return findMedianOf4Numbers(A[0], A[1], B[0], B[1]);
            }

            if (M%2 == 1) {
                return findMedianOf3Numbers(B[M/2], Math.max(A[0], B[M/2 -1]), Math.min(A[1], B[M/2+1]));
            }

            return findMedianOf4Numbers(B[M/2], B[M/2-1], Math.max(A[0], B[M/2-2]), Math.min(A[1], B[M/2+1]));
        }

        int idxA = (N-1)/2;
        int idxB = (M-1)/2;

        if (A[idxA] <= B[idxB]) {
            return findMedianUtil(Arrays.copyOfRange(A, idxA, A.length), N/2,
                                  Arrays.copyOfRange(B, 0, idxB), idxB);
        }


        return findMedianUtil(Arrays.copyOfRange(B, 0, idxA), N/2, Arrays.copyOfRange(B, idxB, B.length), M - idxB);
    }
}
//[1,5,6]
//[2,3,4,7,8]