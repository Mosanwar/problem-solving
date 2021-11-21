package com.example.problemsolving.problems.hackerrank;

public class TreeHuffmanDecoding {
    public static void main(String[] args) {
        Node b = new Node(1, 'B', null, null);
        Node c = new Node(1, 'C', null, null);
        Node bc = new Node(2, null, b, c);
        Node a = new Node(3, 'A', null, null);
        Node root = new Node(5, null, bc, a);

        decode("1001011", root);
    }

    static void decode(String s, Node root) {
        System.out.println(calculateDecodedString(s, new StringBuilder(), root, root));
    }

    static String calculateDecodedString(String encoded, StringBuilder sb, Node root, Node currentNode) {
        if (currentNode.left == null && currentNode.right == null) {
            sb.append(currentNode.data);
            if (encoded.isEmpty()) {
                return sb.toString();
            }
            calculateDecodedString(encoded, sb, root, root);
        } else if (encoded.charAt(0) == '0') {
            calculateDecodedString(encoded.substring(1), sb, root, currentNode.left);
        } else if (encoded.charAt(0) == '1') {
            calculateDecodedString(encoded.substring(1), sb, root, currentNode.right);
        }

        return sb.toString();
    }

    static class Node {
        public  int frequency; // the frequency of this tree
        public  Character data;
        public  Node left, right;

        public Node(int frequency, Character data, Node left, Node right) {
            this.frequency = frequency;
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
