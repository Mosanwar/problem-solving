package com.example.problemsolving.problems.hackerrank;

public class DeleteANodeFromLinkedList {

    public static void main(String[] args) {

    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (llist == null || (llist.next == null && position == 0)) {
            return null;
        }

        SinglyLinkedListNode head = llist;

        for (int i = 0; i <= position; i++) {
            if (llist.next == null) {
                break;
            }
            llist = llist.next;
        }
        llist.next = llist.next.next;

        return head;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
}
