package com.example.problemsolving.problems.hackerrank;

import java.util.HashSet;
import java.util.Set;

public class CycleDetection {
    public static void main(String[] args) {

    }

    static boolean hasCycle(SinglyLinkedListNode head) {
        Set<SinglyLinkedListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    static class SinglyLinkedListNode{
        int data;
        SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
            this.data = data;
            this.next = next;
        }
    }
}
