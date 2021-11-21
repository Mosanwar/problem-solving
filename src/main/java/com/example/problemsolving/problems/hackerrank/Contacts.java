package com.example.problemsolving.problems.hackerrank;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.SynchronousQueue;

public class Contacts {
    public static void main(String[] args) {
        System.out.println(contacts(
                List.of(
                        List.of("add", "ed"),
                        List.of("add", "eddie"),
                        List.of("add", "edward"),
                        List.of("find", "ed"),
                        List.of("add", "edwina"),
                        List.of("find", "edw"),
                        List.of("find", "a")
                        )
        ));
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0).equals("add")) {
                // add
                TrieNode.insert(queries.get(i).get(1));
            } else {
                // find
                result.add(TrieNode.count(queries.get(i).get(1)));
            }
        }

        return result;
    }

    public static List<Integer> contacts2(List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0).equals("add")) {
                for (int j = 1; j < queries.get(i).get(1).length(); j++) {
                    String sub = queries.get(i).get(1).substring(0, j);
                    map.merge(sub, 1, Integer::sum);
                }
            } else {
                if (map.get(queries.get(i).get(1)) == null) {
                    result.add(0);
                } else {
                    result.add(map.get(queries.get(i).get(1)));
                }
            }
        }
        return result;
    }

    static class TrieNode {
        private static TrieNode root = new TrieNode();
        private Map<Character, TrieNode> node = new HashMap<>();
        private int size = 0;
        private boolean word = false;

        public TrieNode() {
        }

        public TrieNode(Map<Character, TrieNode> node, boolean word) {
            this.node = node;
            this.word = word;
        }

        public static void insert(String str) {
            TrieNode current = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                TrieNode node = current.getNode().get(c);
                if (node == null) {
                    node = new TrieNode();
                    current.getNode().put(c, node);
                }

                current = node;
                current.size++;
            }

            current.setWord(true);
        }

        public static Integer count(String str) {
            TrieNode current = root;
//            int count = 0;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (current.getNode().get(c) != null) {
                    current = current.getNode().get(c);
                } else {
                    return 0;
                }
            }

//            Queue<TrieNode> queue = new ConcurrentLinkedQueue<>();
//            queue.add(current);
//
//            while (!queue.isEmpty()) {
//                TrieNode node = queue.poll();
//                if (node != null && node.isWord()) {
//                    count++;
//                }
//
//                if (node != null && node.getNode() != null && !node.getNode().isEmpty()) {
//                    queue.addAll(node.getNode().values());
//                }
//            }
            return current.size;
        }

        public Map<Character, TrieNode> getNode() {
            return node;
        }

        public void setNode(Map<Character, TrieNode> node) {
            this.node = node;
        }

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public TrieNode getRoot() {
            return root;
        }

        public void setRoot(TrieNode root) {
            this.root = root;
        }
    }
}
