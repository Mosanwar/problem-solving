package com.example.problemsolving.problems.ascendion;

import java.util.Arrays;

public class TSYS {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getDiscounts(new Integer[] {-1,-2,-3,-4,-5})));
    }

    public static Integer[] getDiscounts(Integer[] prices) {
        Integer[] result = new Integer[prices.length];
        result[prices.length-1] = prices[prices.length-1];
        boolean foundDiscount;

        for (int i = 0; i < prices.length-1; i++) {
            foundDiscount = false;
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]<prices[i]) {
                    result[i] = prices[i]-1;
                    foundDiscount = true;
                    break;
                }
            }
            if (!foundDiscount) {
                result[i] = prices[i];
            }
        }

        return result;
    }
}
