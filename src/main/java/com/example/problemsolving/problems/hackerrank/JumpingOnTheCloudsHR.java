package com.example.problemsolving.problems.hackerrank;

public class JumpingOnTheCloudsHR {
    public static void main(String[] args) {
        int[] data = {0, 0, 1, 0, 0, 1, 1, 0};
        System.out.println(jumpingOnClouds(data, 2));
    }

    static int jumpingOnClouds(int[] c, int k) {
        int thunderCount = 0;
        int steps = 0;
        int index = 0;
        while (true) {
            steps++;
            if (c[index] == 1) {
                thunderCount++;
            }

            index = (index + k) % c.length;
            if (index == 0) {
                break;
            }
        }

        return 100 - steps - thunderCount * 2;
    }
}
