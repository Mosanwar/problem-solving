package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComponentsInAGraph {
    public static void main(String[] args) {
        System.out.println(componentsInGraph(List.of(
                List.of(1, 6),
                List.of(2, 7),
                List.of(3, 8),
                List.of(4, 9),
                List.of(2, 6)
        )));
    }

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        // Write your code here
        List<Set<Integer>> graph = new ArrayList<>();
        boolean found;

        for (int i = 0; i < gb.size(); i++) {
            found = false;
            for (int j = 0; j < graph.size(); j++) {
                if (graph.get(j).contains(gb.get(i).get(0))) {
                    graph.get(j).add(gb.get(i).get(1));
                    found = true;
                } else if (graph.get(j).contains(gb.get(i).get(1))) {
                    graph.get(j).add(gb.get(i).get(0));
                    found = true;
                }
            }
            if (!found) {
                Set<Integer> set = new HashSet<>();
                set.add(gb.get(i).get(0));
                set.add(gb.get(i).get(1));
                graph.add(set);
            }
        }

        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < graph.size(); i++) {
            max = Math.max(max, graph.get(i).size());
            min = Math.min(min, graph.get(i).size());
        }
        return List.of(min, max);
    }
}
