package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringAnagram {
    public static void main(String[] args) {
        System.out.println(stringAnagram(
                List.of("hack", "a", "rank", "khac", "ackh", "kran", "rankhacker", "a", "ab", "bo", "stairs", "raits"),
                List.of("a", "nark", "bs", "hack", "stair")
        ));
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        String[] dic = new String[dictionary.size()];
        String[] que = new String[query.size()];
        List<Integer> result = new ArrayList<>();

        char[] chars;

        for (int i = 0; i < dic.length; i++) {
            chars = dictionary.get(i).toCharArray();
            Arrays.sort(chars);
            dic[i] = String.valueOf(chars);
        }

        for (int i = 0; i < que.length; i++) {
            chars = query.get(i).toCharArray();
            Arrays.sort(chars);
            que[i] = String.valueOf(chars);
        }

        int total = 0;
        for (int i = 0; i < que.length; i++) {

            for (int j = 0; j < dic.length; j++) {
                if (Objects.equals(que[i], dic[j])) {
                    total++;
                }
            }

            result.add(total);
            total = 0;
        }

        return result;
    }
}
