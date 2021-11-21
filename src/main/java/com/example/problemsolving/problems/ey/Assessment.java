package com.example.problemsolving.problems.ey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Assessment {
    public static void main(String[] args) {

    }

    public static String printAlternative(String numbers) {
        String[] nums = numbers.split(" ");

        for (int i = 0; i < nums.length; i++) {
            Stack.push(Integer.parseInt(nums[i]));
        }
        String result = "";

        for (int i = 0; i < Stack.size(); i++) {
            result += " " + Stack.pop();
            Stack.pop();
        }
        return result.substring(0, result.length()-1);
    }

    public static class Stack {
        static List<Integer> stackList = new ArrayList<>();

        public static void push (Integer i) {
            stackList.add(i);
        }

        public static Integer pop () {
            Integer removedItem = null;
            if (!stackList.isEmpty()) {
                removedItem = stackList.get(stackList.size()-1);
                stackList.remove(stackList.get(stackList.size()-1));
            }
            return removedItem;
        }

        public static int size() {
            return stackList.size();
        }
    }
    /*
    Am I local?
Programming challenge description:
A network block is defined by an IP address and a subnet mask. The mask value separates the network address from the internal address based on how many bits are hidden by the mask.

For example, an 8-bit subnet mask is expressed as 255.0.0.0. An IP address of 10.21.8.15 with that mask applied reveals a network address of 10.0.0.0.

Your challenge is to inspect an IP address and mask number, then decide if another IP address is on that local network.

Considering the IP block 10.0.0.0 and a subnet mask of 255.0.0.0, we can represent this like so: 10.0.0.0/8 (this is called CIDR notation).

As an example, the address 10.21.8.15 would be on the local network. The address 11.34.57.1 would not.

Input:
Two lines of input as follows:

IPv4 Network block in standard CIDR notation
IPv4 Address to Check
Output:
If the IP address is in the subnet defined by the CIDR, print "True". Otherwise, print "False".

Test 1
Test Input
Download Test 1 Input
10.10.0.0/8
10.22.11.16
Expected Output
Download Test 1 Input
True
Test 2
Test Input
Download Test 2 Input
10.10.231.124/16
10.22.11.16
Expected Output
Download Test 2 Input
False
Test 3
Test Input
Download Test 3 Input
192.168.0.0/18
192.168.16.1
Expected Output
Download Test 3 Input
True
     */

}
