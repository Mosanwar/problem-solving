package com.example.problemsolving.problems.hackerrank;

import java.util.Scanner;

public class IsThisABinarySearchTree {
    public static void main(String[] args) {
//        Node node1 = new Node(1);
//        Node node4 = new Node(4);
//        Node node5 = new Node(5, node1, node4);
//        Node node6 = new Node(6);
//        Node node2 = new Node(2, node6, null);
//        Node node3 = new Node(3, node5, node2);
//
//        System.out.println(checkBST(node3));

        Node node1 = new Node(1);
        Node node4 = new Node(4);
        Node node2 = new Node(2, node1, node4);
        Node node5 = new Node(5);
        Node node3 = new Node(3, node2, node5);

        System.out.println(checkBST(node3));
    }

    static boolean checkBST(Node root) {
        return isBST(root);
    }

    private static boolean isBST(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        } else if ((root.left != null && root.data <= root.left.data) || (root.right != null && root.data >= root.right.data)) {
            return false;
        } else {
            return isBST(root.left) && isBST(root.right);
        }
    }

    public static class Node {
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        int data;
        Node left;
        Node right;
    }
}
