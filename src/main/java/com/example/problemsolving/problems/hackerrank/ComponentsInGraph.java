package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComponentsInGraph {
//    https://www.hackerrank.com/challenges/components-in-graph/problem?isFullScreen=true
    public static void main(String[] args) {
        System.out.println(componentsInGraph(List.of(List.of(1, 6),List.of(2, 7), List.of(3, 8), List.of(4,9), List.of(2, 6))));
    }

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
        // Write your code here
        int smallest = Integer.MAX_VALUE;
        int largest = 0;

        List<Set<Integer>> groups = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(gb.get(0).get(0));
        set.add(gb.get(0).get(1));
        groups.add(set);

        for (List<Integer> list : gb) {
            for (Set<Integer> group : groups) {
                if (group.contains(list.get(0))) {
                    group.add(list.get(1));
                } else if (group.contains(list.get(1))) {
                    group.add(list.get(0));
                } else {
                    Set<Integer> newGroup = new HashSet<>();
                    newGroup.add(list.get(0));
                    newGroup.add(list.get(1));
                    groups.add(newGroup);
                }
            }
        }

        for (int i = 0; i < groups.size() - 1; i++) {
            for (int j = i + 1; j < groups.size(); j++) {
                if (groups.get(i).containsAll(groups.get(j))) {
                    groups.get(j).addAll(groups.get(i));
                }
            }
        }

        for (Set<Integer> group: groups) {
            smallest = Math.min(smallest, group.size());
            largest = Math.max(largest, group.size());
        }

        return List.of(smallest, largest);
    }
}
