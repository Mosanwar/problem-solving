package com.example.problemsolving.problems.hackerrank;

public class TaumAndBDay {
//    https://www.hackerrank.com/challenges/taum-and-bday/problem?isFullScreen=true

    public static void main(String[] args) {

    }

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        return (long) b * Math.min(bc, wc+z) + (long) w * Math.min(wc, bc+z);
    }
}
