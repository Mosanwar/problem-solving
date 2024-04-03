package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class ACMICPCTeam {
    public static void main(String[] args) {
        System.out.println(acmTeam(List.of("11101", "10101", "11001", "10111", "10000", "01110")));
    }

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        int maxTopics = 0;

        int currentTopics;

        int topicsResult = 0;
        int teamsResult = 0;

        for (int i = 0; i < topic.size()-1; i++) {
            for (int j = i+1; j < topic.size(); j++) {
                int index1 = 0;
                int index2 = 0;

                currentTopics = 0;
                while (index1 < topic.get(i).length() || index2 < topic.get(j).length()) {
                    if ((index1 < topic.get(i).length() && topic.get(i).charAt(index1) == '1') ||
                            (index2 < topic.get(j).length() && topic.get(j).charAt(index2) == '1')) {
                        currentTopics++;
                    }

                    index1++;
                    index2++;
                }

                if (currentTopics > maxTopics) {
                    maxTopics = currentTopics;
                    teamsResult = 1;
                } else if (currentTopics == maxTopics) {
                    teamsResult++;
                }

            }
        }
        return List.of(maxTopics, teamsResult);
    }

    /*currentTopics = 0;
            for (int j = 1; j < topic.size(); j++) {
                if (topic.get(i) == "1" || topic.get(j) == "1") {
                    currentTopics++;
                }
            }

            if (currentTopics > maxTopics) {
                maxTopics = currentTopics;
                topicsResult++;
                teamsResult++;
            }*/
}
