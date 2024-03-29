package com.example.problemsolving.problems.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Equal {

    public static void main(String[] args) {

    }

    public static int equal(List<Integer> arr) {
        int[] possibilities = new int[5];
        int minNoOfCh = arr.stream().min(Integer::compare).orElse(0);

        for (int i = 0; i < possibilities.length; i++) {
            for (Integer num : arr) {
                int diff = num - minNoOfCh;
                int stepRequired = (diff / 5) + ((diff % 5) / 2) + ((diff % 5) % 2) / 1;

                possibilities[i] += stepRequired;
            }
            minNoOfCh--;
        }

        return Arrays.stream(possibilities).min().getAsInt();
    }
}

/*
* Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues. She is biased towards her friends and plans to give them more than the others. One of the program managers hears of this and tells her to make sure everyone gets the same number.

To make things difficult, she must equalize the number of chocolates in a series of operations. For each operation, she can give  pieces to all but one colleague. Everyone who gets a piece in a round receives the same number of pieces.

Given a starting distribution, calculate the minimum number of operations needed so that every colleague has the same number of pieces.

Example

 represents the starting numbers of pieces for each colleague. She can give  pieces to the first two and the distribution is then . On the next round, she gives the same two  pieces each, and everyone has the same number: . Return the number of rounds, .

Function Description

Complete the equal function in the editor below.

equal has the following parameter(s):

int arr[n]: the integers to equalize
Returns

int: the minimum number of operations required
Input Format

The first line contains an integer , the number of test cases.

Each test case has  lines.
- The first line contains an integer , the number of colleagues and the size of .
- The second line contains  space-separated integers, , the numbers of pieces of chocolate each colleague has at the start.

Constraints



The number of chocolates each colleague has initially < .

Sample Input

STDIN       Function
-----       --------
1           t = 1
4           arr[] size n = 4
2 2 3 7     arr =[2, 2, 3, 7]
Sample Output

2
Explanation

Start with
Add  to all but the 3rd element
Add  to all but the 4th element

Two operations were required.

Sample Input 1

1
3
10 7 12
Sample Output 1

3
Explanation 1

Start with
Add  to the first two elements
Add  to the last two elements
Add  to the last two elements

Three operations were required.
* */