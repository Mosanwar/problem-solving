package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ActiveTraders {
    public static void main(String[] args) {
        System.out.println(mostActive(List.of("Alpha", "Beta", "Zeta", "Beta", "Zeta", "Zeta", "Epsilon", "Beta", "Zeta", "Beta", "Zeta", "Beta", "Delta", "Zeta", "Beta", "Zeta", "Beta", "Zeta", "Beta", "Zeta", "Beta"
        )));
    }

    public static List<String> mostActive(List<String> customers) {
        // Write your code here
        Map<String, Integer> map = new HashMap<>();

        for(String name: customers) {
            if (map.get(name) == null) {
                map.put(name, 1);
            } else {
                map.put(name, map.get(name)+1);
            }
        }

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Integer> entry :map.entrySet()) {
            if (entry.getValue()*100.00/customers.size() >= 5) {
                result.add(entry.getKey());
            }
        }

        return result.stream().sorted().collect(Collectors.toList());
    }
}
