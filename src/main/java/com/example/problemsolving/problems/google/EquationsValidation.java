package com.example.problemsolving.problems.google;

import java.util.*;
/*
* this problem is about you'll get an array of equations and see if equations are valid or not
* you'll only get equations between 2 chars and only '>' or '<' operators
* ex: A < B && A > B -> is not valid
* ex: A < B && B < C && A > C -> is not valid
* */
public class EquationsValidation {
    public static void main(String[] args) {
        // I want to prove that A is lt one of chars that is lt D to prove this is not valid equation

        char[][] equations = new char[][] {
                {'A', '<', 'B'},
                {'B', '<', 'C'},
                {'C', '<', 'D'},
                {'D', '<', 'E'},
                {'C', '>', 'E'},
        };

        System.out.println(isValid(equations));
    }

    public static boolean isValid(char[][] equations) {
        Map<Character, Set<Character>> store = new HashMap<>();
        char smaller, greater;
        Queue<Character> queue = new PriorityQueue<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < equations.length; i++) {
            // to know which char is greater and which is smaller
            if (equations[i][1] == '<') {
                smaller = equations[i][0];
                greater = equations[i][2];
            } else {
                smaller = equations[i][2];
                greater = equations[i][0];
            }

            // validate with previous equations
            if (store.containsKey(greater)) {
                queue.add(greater);
                char current;
                while (!queue.isEmpty()) {
                    current = queue.poll();
                    if (visited.contains(current)) continue;
                    visited.add(current);
                    if (current == smaller) {
                        System.out.println("Wrong equation: " + Arrays.toString(equations[i]));
                        return false;
                    }
                    if (store.get(current) != null) {
                        queue.addAll(store.get(current));
                    }
                }
            }

            //add to store
            if (store.containsKey(smaller)) {
                store.get(smaller).add(greater);
            } else {
                Set<Character> g = new HashSet<>();
                g.add(greater);
                store.put(smaller, g);
            }

        }

        return true;
    }
}
