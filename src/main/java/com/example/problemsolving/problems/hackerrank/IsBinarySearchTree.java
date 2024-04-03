package com.example.problemsolving.problems.hackerrank;

public class IsBinarySearchTree {
//    https://www.hackerrank.com/challenges/is-binary-search-tree/problem?isFullScreen=true
    public static void main(String[] args) {

    }

//    boolean checkBST(Node root) {
//        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }

//    boolean checkBSTHelper(Node node, int min, int max) {
//        if (node == null || (node.left == null && node.right == null)) {
//            return true;
//        }
//        if ((node.left != null && node.data < node.left.data) || node.right != null && node.data > node.right.data) {
//            return false;
//        }
//
//        return checkBSTHelper(node.left, min, node.data) && checkBSTHelper(node.right, node.data, max);
//    }

//    static boolean checkBST(Node root) {
//        if (root == null) {
//            return true;
//        }
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//
//        Set<Integer> set = new HashSet<>();
//
//        while (!queue.isEmpty()) {
//            Node node = queue.poll();
//            if (node != null && set.contains(node.data)) {
//                return false;
//            }
//
//            if (node != null) {
//                set.add(node.data);
//                if (node.left != null && node.data < node.left.data) {
//                    return false;
//                } else if (node.right != null && node.data > node.right.data) {
//                    return false;
//                }
//                queue.add(node.left);
//                queue.add(node.right);
//            }
//        }
//        return true;
//    }

    boolean checkBST(Node root) {
        return checkBST1(root, -1, 10000);
    }

    boolean checkBST1(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data <= min || root.data >= max)
            return false;

        return checkBST1(root.left, min, root.data) && checkBST1(root.right, root.data, max)
                ;
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
