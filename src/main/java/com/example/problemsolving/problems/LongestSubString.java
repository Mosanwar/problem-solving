package com.example.problemsolving.problems;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(longestSubstring2("abcdefaghi"));
    }

    public static String longestSubstring(String str) {
        String longestSubstring = "";
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (list.contains(str.charAt(i))){
                longestSubstring = longestSubstring.length() >= list.size() ? longestSubstring : StringUtils.collectionToDelimitedString(list, "");
                deleteUntilChar(list, str.charAt(i));
            }
            list.add(str.charAt(i));
        }

        return longestSubstring.length() >= list.size() ? longestSubstring : StringUtils.collectionToDelimitedString(list, "");
    }

    private static void deleteUntilChar(List<Character> list, char c) {
        int size = list.size();
        for (int i = 0; i < size; i++) {

            if (i >= list.size()) {
                break;
            }

            if (list.get(i) == c) {
                list.remove(i);
                break;
            }


            list.remove(i);
        }
    }

    public static String longestSubstring2(String str) {
        String longestSubstring = "";
        Queue<Character> queue = new ConcurrentLinkedQueue<>();

        for (int i = 0; i < str.length(); i++) {
            if (queue.contains(str.charAt(i))) {
                longestSubstring = longestSubstring.length() >= queue.size() ? longestSubstring : StringUtils.collectionToDelimitedString(queue, "");
                char c = queue.poll();
                while (c != str.charAt(i)) {
                    c = queue.poll();
                }

            }
            queue.add(str.charAt(i));
        }

        return longestSubstring.length() >= queue.size() ? longestSubstring : StringUtils.collectionToDelimitedString(queue, "");
    }
}
