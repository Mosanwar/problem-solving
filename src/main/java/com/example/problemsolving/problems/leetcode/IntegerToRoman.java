package com.example.problemsolving.problems.leetcode;

//https://leetcode.com/problems/integer-to-roman/description/
public class IntegerToRoman {

    final static int[] val = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    final static String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static void main(String[] args) {
        System.out.println(intToRoman(453));
    }

    // 453
    public static String intToRoman(int num) {
        StringBuilder br = new StringBuilder();
        for (int i = 0; num > 0; i++) {
            while (num >= val[i]) {
                br.append(rom[i]);
                num -= val[i];
            }
        }
        return br.toString();
    }
}
