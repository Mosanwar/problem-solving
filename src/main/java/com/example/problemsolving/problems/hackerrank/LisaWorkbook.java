package com.example.problemsolving.problems.hackerrank;

import java.util.List;

public class LisaWorkbook {
//    https://www.hackerrank.com/challenges/lisa-workbook/problem

    public static void main(String[] args) {
        System.out.println(workbook(5, 3, List.of(4, 2, 6, 1, 10)));
    }

    public static int workbook(int n, int k, List<Integer> arr) {
        // Write your code here
        int numberOfPages = 0;

        for (Integer integer : arr) {
            numberOfPages += (int) Math.ceil((double)integer / k);
        }

        if (k == 1 && arr.size() == 1) {
            return numberOfPages;
        }

        int currentPage = 1;
        int currentChapterIndex = 1;
        int currentPageInChapter = 0;
        int numberOfProblemsInCurrentPage;
        int result = 0;

        while (currentPage <= numberOfPages) {
            currentPageInChapter++;
            Integer probsPerChapter = arr.get(currentChapterIndex - 1);
            if (probsPerChapter >= currentPageInChapter * k) {
                numberOfProblemsInCurrentPage = k;
            } else {
                numberOfProblemsInCurrentPage = probsPerChapter % k;
            }

            if (currentPage >= ((currentPageInChapter-1) * k) + 1 && currentPage <= ((currentPageInChapter-1) * k) + numberOfProblemsInCurrentPage) {
                result++;
            }

            if (Math.ceil((double) probsPerChapter / k) == currentPageInChapter) {
                currentChapterIndex++;
                currentPageInChapter = 0;
            }

            currentPage++;

        }

        return result;
    }
}
