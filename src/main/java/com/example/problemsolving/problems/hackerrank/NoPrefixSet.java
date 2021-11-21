package com.example.problemsolving.problems.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoPrefixSet {
    public static void main(String[] args) {
        noPrefix(List.of("aab", "aac", "aacghgh", "aabghgh"));
    }

    public static void noPrefix(List<String> words) {
        // Write your code here
        boolean badSet = false;
        for (int i = 0; i < words.size(); i++) {
            if (!Trie.add(words.get(i))) {
                System.out.println("BAD SET");
                System.out.println(words.get(i));
                badSet = true;
                break;
            }
        }
        if (!badSet) {
            System.out.println("GOOD SET");
        }

    }

    static class TrieNode {
        private Map<Character, TrieNode> children = new HashMap<>();
        boolean word = false;
    }

    static class Trie {
        static TrieNode root = new TrieNode();

        public static boolean add (String str) {
            TrieNode current = root;
            boolean foundNewPath = false;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (current.children.get(c) == null) {
                    TrieNode node = new TrieNode();
                    current.children.put(c, node);
                    foundNewPath = true;
                } else if (current.word) {
                    return false;
                }
                if (i == str.length()-1) {
                    current.word = true;
                }
                current = current.children.get(c);
            }
            if (!foundNewPath) {
                return false;
            }

            return true;
        }
    }
}
