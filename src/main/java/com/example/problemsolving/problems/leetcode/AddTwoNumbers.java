package com.example.problemsolving.problems.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        ListNode l1 = new ListNode(9);
//        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));

        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> s1 = new LinkedBlockingDeque<>();
        Queue<Integer> s2 = new LinkedBlockingDeque<>();
        int loopCounter = 0;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.add(l1.val);
                l1 = l1.next;
            }

            if (l2 != null) {
                s2.add(l2.val);
                l2 = l2.next;
            }

            loopCounter++;
        }

        Queue<Integer> sum = new LinkedBlockingDeque<>();
        int currSum;
        int curry = 0;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            currSum = (s1.isEmpty() ? 0 : s1.poll()) + (s2.isEmpty() ? 0 : s2.poll()) + curry;
            if (currSum >= 10) {
                sum.add(currSum - 10);
                curry = 1;
            } else {
                sum.add(currSum);
                curry = 0;
            }
        }

        if (curry == 1) {
            sum.add(curry);
        }

        ListNode listNode = new ListNode(sum.poll());
        ListNode result = listNode;

        while (!sum.isEmpty()) {
            listNode.next = new ListNode(sum.poll());
            listNode = listNode.next;
        }

        return result;
    }

    static class ListNode {
        ListNode next;
        Integer val;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
