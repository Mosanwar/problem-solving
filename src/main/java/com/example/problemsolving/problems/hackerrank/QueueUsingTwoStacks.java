package com.example.problemsolving.problems.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class QueueUsingTwoStacks {
    public static Stack<Integer> stack1 = new Stack<>();
    public static Stack<Integer> stack2 = new Stack<>();

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int query;
//        int qNum = sc.nextInt();
//        for (int i = 0; i < qNum; i++) {
//            query = sc.nextInt();
//            if (query == 1) {
//                Integer number = sc.nextInt();
//                enqueue(number);
//            } else if (query == 2) {
//                dequeue();
//            } else if (query == 3) {
//                print();
//            }
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qs = sc.nextInt();
        List<Integer> queue = new ArrayList<>();
        int query;

        for (int i = 0; i < qs; i++) {
            query = sc.nextInt();
            if(query == 1) {
                queue.add(sc.nextInt());
            } else if (query == 2 && !queue.isEmpty()) {
                queue.remove(0);
            } else if (query == 3 && !queue.isEmpty()) {
                System.out.println(queue.get(0));
            }
        }
    }

    public static void enqueue(Integer x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    public static void dequeue() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack2.pop();
    }

    public static void print() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        System.out.println(stack2.peek());
    }
}
