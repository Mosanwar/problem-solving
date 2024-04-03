package com.example.problemsolving.problems.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//    #1249
public class MinimumRemoveToMakeValidParentheses {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
    }

    public static String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Set<Integer> invalidIndices = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    invalidIndices.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        invalidIndices.addAll(stack);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!invalidIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
