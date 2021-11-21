package com.example.problemsolving.problems.projecteuler;

public class ProblemsArchives {
    public static void main(String[] args) {
        System.out.println(multiple3and5(1000));
    }

    public static int multiple3and5 (int number){
        int result = 0;
        for (int i = 1; i < number; i++) {
            if (i%3 == 0 || i%5 == 0) {
                result += i;
            }
        }
        return result;
    }
}
