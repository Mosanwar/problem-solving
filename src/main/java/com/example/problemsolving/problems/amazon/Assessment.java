package com.example.problemsolving.problems.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Assessment {

    public static void main(String[] args) {
        SinglyLinkedListNode node4 = new SinglyLinkedListNode(2, null);
        SinglyLinkedListNode node3 = new SinglyLinkedListNode(3, node4);
        SinglyLinkedListNode node2 = new SinglyLinkedListNode(4, node3);
        SinglyLinkedListNode node1 = new SinglyLinkedListNode(1, node2);
//
//        System.out.println(maximumPages(node1));
        System.out.println(maximumPages2(node1));

//        System.out.println(isValidDiscount("caaebbc"));

//        System.out.println(findValidDiscountCoupons(List.of("abba", "abca", "cccc")));
    }

    public static int maximumPages(SinglyLinkedListNode head) {
        // Write your code here
        int maxPages = 0;
        SinglyLinkedListNode lastNode;
        while (head != null) {
            lastNode = head;
            while (lastNode.next.next != null) {
                lastNode = lastNode.next;
            }
            maxPages = Math.max(maxPages, (head.data + lastNode.next.data));
            lastNode.next = null;
            head = head.next;
        }

        return maxPages;
    }

    public static int maximumPages2(SinglyLinkedListNode head) {
        List<SinglyLinkedListNode> list = new ArrayList<>();
        list.add(head);
        while (head.next != null) {
            head = head.next;
            list.add(head);
        }
        int maxPages = 0;
        for (int i = 0; i < list.size()/2; i++) {
            maxPages = Math.max(maxPages, (list.get(i).data + list.get(list.size()-i-1).data));
        }

        return maxPages;
    }

    public static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode (int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static List<Integer> findValidDiscountCoupons(List<String> discounts) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < discounts.size(); i++) {
            String discount = discounts.get(i);
            if (discount == null || discount.equals("")) {
                result.add(1);
                continue;
            }

            if (discount.length() % 2 != 0) {
                result.add(0);
                continue;
            }

            if (isValidDiscount(discount)) {
                result.add(1);
            } else {
                result.add(0);
            }

        }

        return result;
    }

    private static boolean isValidDiscount(String discount) {
        if (discount.length() < 2) {
            return false;
        }
        if (discount.length() == 2) {
            return discount.charAt(0) == discount.charAt(1);
        }
        for (int i = 0; i < discount.length() - 1; i++) {
            if (discount.charAt(i) == discount.charAt(i + 1)) {
                return isValidDiscount(discount.substring(0, i) + discount.substring(i + 2));
            }
        }

        return false;
    }

    private static boolean isValidDiscount2(String discount) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < discount.length(); i++) {
            if (stack.empty()) {
                stack.push(discount.charAt(i));
            }

            else if (stack.peek() == discount.charAt(i)) {
                stack.pop();
            } else stack.push(discount.charAt(i));
        }

        return stack.empty();
    }
}
