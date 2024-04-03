package com.example.problemsolving.problems.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        // abcabcbb
        // q = {a, b, c}
        // s = {a, b, c}
        // q
        System.out.println(lengthOfLongestSubstring(" bb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                char removed = queue.poll();
                set.remove(removed);

                while (removed != c && !queue.isEmpty()) {
                    removed = queue.poll();
                    set.remove(removed);
                }
            }
            queue.add(c);
            set.add(c);
            result = Math.max(result, queue.size());
        }
        return result;
    }
}
