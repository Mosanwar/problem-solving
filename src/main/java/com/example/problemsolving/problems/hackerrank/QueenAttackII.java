package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class QueenAttackII {
    public static void main(String[] args) {
        System.out.println(queensAttack(100, 100, 48, 81, List.of(
                List.of(54, 87),
                List.of(64, 97),
                List.of(42, 75),
                List.of(32, 65),
                List.of(42, 87),
                List.of(32, 97),
                List.of(54, 75),
                List.of(64, 65),
                List.of(48, 87),
                List.of(48, 75),
                List.of(54, 81),
                List.of(42, 81),
                List.of(45, 17),
                List.of(14, 24),
                List.of(35, 15),
                List.of(95, 64),
                List.of(63, 87),
                List.of(25, 72),
                List.of(71, 38),
                List.of(96, 97),
                List.of(16, 30),
                List.of(60, 34),
                List.of(31, 67),
                List.of(26, 82),
                List.of(20, 93),
                List.of(81, 38),
                List.of(51, 94),
                List.of(75, 41),
                List.of(79, 84),
                List.of(79, 65),
                List.of(76, 80),
                List.of(52, 87),
                List.of(81, 54),
                List.of(89, 52),
                List.of(20, 31),
                List.of(10, 41),
                List.of(32, 73),
                List.of(83, 98),
                List.of(87, 61),
                List.of(82, 52),
                List.of(80, 64),
                List.of(82, 46),
                List.of(49, 21),
                List.of(73, 86),
                List.of(37, 70),
                List.of(43, 12),
                List.of(94, 28),
                List.of(10, 93),
                List.of(52, 25),
                List.of(50, 61),
                List.of(52, 68),
                List.of(52, 23),
                List.of(60, 91),
                List.of(79, 17),
                List.of(93, 82),
                List.of(12, 18),
                List.of(75, 64),
                List.of(69, 69),
                List.of(94, 74),
                List.of(61, 61),
                List.of(46, 57),
                List.of(67, 45),
                List.of(96, 64),
                List.of(83, 89),
                List.of(58, 87),
                List.of(76, 53),
                List.of(79, 21),
                List.of(94, 70),
                List.of(16, 10),
                List.of(50, 82),
                List.of(92, 20),
                List.of(40, 51),
                List.of(49, 28),
                List.of(51, 82),
                List.of(35, 16),
                List.of(15, 86),
                List.of(78, 89),
                List.of(41, 98),
                List.of(70, 46),
                List.of(79, 79),
                List.of(24, 40),
                List.of(91, 13),
                List.of(59, 73),
                List.of(35, 32),
                List.of(40, 31),
                List.of(14, 31),
                List.of(71, 35),
                List.of(96, 18),
                List.of(27, 39),
                List.of(28, 38),
                List.of(41, 36),
                List.of(31, 63),
                List.of(52, 48),
                List.of(81, 25),
                List.of(49, 90),
                List.of(32, 65),
                List.of(25, 45),
                List.of(63, 94),
                List.of(89, 50),
                List.of(43, 41)
        )));
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int attackedSquares = 0;
        int x = c_q+1;

        //+x axe
        while (x <= n){
            if (obstacles.contains(List.of(r_q, x))) {
                break;
            }

            attackedSquares++;
            x++;
        }

        //-x axe
        x = c_q-1;
        while (x >= 1) {
            if (obstacles.contains(List.of(r_q, x))) {
                break;
            }

            attackedSquares++;
            x--;
        }

        //+y axe
        int y = r_q+1;
        while (y <= n) {
            if (obstacles.contains(List.of(y, c_q))) {
                break;
            }

            attackedSquares++;
            y++;
        }

        //-y axe
        y = r_q - 1;
        while (y >= 1) {
            if (obstacles.contains(List.of(y, c_q))) {
                break;
            }

            attackedSquares++;
            y--;
        }

        //+xy axe
        x = c_q+1;
        y = r_q+1;
        while (x <= n && y <= n) {
            if (obstacles.contains(List.of(y, x))) {
                break;
            }

            attackedSquares++;
            x++;
            y++;
        }

        //-xy axe
        x = c_q-1;
        y = r_q-1;
        while (x >= 1 && y >= 1) {
            if (obstacles.contains(List.of(y, x))) {
                break;
            }

            attackedSquares++;
            x--;
            y--;
        }

        //-x+y axe
        x = c_q - 1;
        y = r_q + 1;
        while (x >= 1 && y <= n) {
            if (obstacles.contains(List.of(y, x))) {
                break;
            }

            attackedSquares++;
            x--;
            y++;
        }

        //+x-y
        x = c_q + 1;
        y = r_q - 1;
        while (x <= n && y >= 1) {
            if (obstacles.contains(List.of(y, x))) {
                break;
            }

            attackedSquares++;
            x++;
            y--;
        }
        return attackedSquares;
    }
}
