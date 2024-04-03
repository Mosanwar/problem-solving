package com.example.problemsolving.problems.ascendion;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWrongEntranceRecord {
    public static void main(String[] args) {
        List<List<String>> records1 = List.of(
          List.of("Martha",   "exit"),
          List.of("Paul",     "enter"),
          List.of("Martha",   "enter"),
          List.of("Steve",    "enter"),
          List.of("Martha",   "exit"),
          List.of("Jennifer", "enter"),
          List.of("Paul",     "enter"),
          List.of("Curtis",   "exit"),
          List.of("Curtis",   "enter"),
          List.of("Paul",     "exit"),
          List.of("Martha",   "enter"),
          List.of("Martha",   "exit"),
          List.of("Jennifer", "exit"),
          List.of("Paul",     "enter"),
          List.of("Paul",     "enter"),
          List.of("Martha",   "exit"),
          List.of("Paul",     "enter"),
          List.of("Paul",     "enter"),
          List.of("Paul",     "exit"),
          List.of("Paul",     "exit")
        );

        System.out.println(exitWithoutEntering(records1));
        System.out.println(enterWithoutExiting(records1));
    }

    public static Set<String> exitWithoutEntering (List<List<String>> list) {
        Set<String> result = new HashSet<>();
        Set<String> inside = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {

            if (result.contains(list.get(i).get(0))) {
                continue;
            }

            if (list.get(i).get(1).equals("exit") && !inside.contains(list.get(i).get(0))) {
                result.add(list.get(i).get(0));
            } else if (list.get(i).get(1).equals("exit")) {
                inside.remove(list.get(i).get(0));
            } else {
                inside.add(list.get(i).get(0));
            }
        }

        return result;
    }

    public static Set<String> enterWithoutExiting (List<List<String>> list) {
        Set<String> result = new HashSet<>();
        Set<String> inside = new HashSet<>();

        for (int i = 0; i < list.size(); i++) {

            if (result.contains(list.get(i).get(0))) {
                continue;
            }

            if (list.get(i).get(1).equals("enter") && inside.contains(list.get(i).get(0))) {
                result.add(list.get(i).get(0));
            } else if (list.get(i).get(1).equals("exit")) {
                inside.remove(list.get(i).get(0));
            } else {
                inside.add(list.get(i).get(0));
            }
        }

        return result;
    }
}
