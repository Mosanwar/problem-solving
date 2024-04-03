package com.example.problemsolving.problems.hackerrank;

import java.util.Stack;

public class FindMergePointOfTwoLists {
    public static void main(String[] args) {

    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        Stack<SinglyLinkedListNode> stack1 = new Stack<>();
        Stack<SinglyLinkedListNode> stack2 = new Stack<>();

        while (head1 != null) {
            stack1.push(head1);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2);
            head2 = head2.next;
        }

        int result = 0;
        SinglyLinkedListNode curData1 = null;
        SinglyLinkedListNode curData2 = null;
        while (!stack1.empty() && !stack2.empty()) {
            curData1 = stack1.pop();
            curData2 = stack2.pop();
            if (curData1 != curData2) {
                return result;
            }
            result = curData1.data;
        }
        return result;
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
