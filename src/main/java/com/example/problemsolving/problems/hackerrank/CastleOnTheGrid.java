package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class CastleOnTheGrid {
//    https://www.hackerrank.com/challenges/castle-on-the-grid/problem?isFullScreen=false

    public static void main(String[] args) {

    }

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        return 0;
    }

    public static void nextStep(List<String> grid,
                                int currentX, int currentY,
                                int goalX, int goalY,
                                List<List<Integer>> path,
                                List<List<List<Integer>>> solutions) {
        if (currentX+1 == goalX && currentY == goalY) {
            path.add(List.of(currentX+1, currentY));
            solutions.add(path);
            return;
        } else if (currentX-1 == goalX && currentY == goalY) {
            path.add(List.of(currentX-1, currentY));
            solutions.add(path);
            return;
        } else if (currentX == goalX && currentY+1 == goalY) {
            path.add(List.of(currentX, currentY+1));
            solutions.add(path);
            return;
        }

        System.out.println();
    }
}
