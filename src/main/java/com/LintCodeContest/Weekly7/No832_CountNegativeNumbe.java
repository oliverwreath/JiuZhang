package com.LintCodeContest.Weekly7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No832_CountNegativeNumbe {
    private static final Logger logger = LoggerFactory.getLogger(No832_CountNegativeNumbe.class);

    public static void main(String[] args) {
        No832_CountNegativeNumbe No832_CountNegativeNumbe = new No832_CountNegativeNumbe();
        No832_CountNegativeNumbe.testNo832_CountNegativeNumbe();
    }

    private void testNo832_CountNegativeNumbe() {
        MyLogger.info("result 5 v.s. " + countNumber(new int[][]{
                {-5, -3, -1, 0, 1},
                {-2, -1, 0, 0, 1},
                {0, 11, 12, 12, 14}
        }));
        MyLogger.info("result 11 v.s. " + countNumber(new int[][]{
                {-50, -30, -10, -5},
                {-30, -20, -5, -1},
                {-10, -5, -1, 0}
        }));
    }

    int countNumber(int[][] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int m = A.length;
        int n = A[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
//            int tmp = binarySearch(A[i]);
//            System.out.println(tmp);
            count += binarySearch(A[i]);
        }

        // return the final result
        return count;
    }

    int binarySearch(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = ((end - start) >> 1) + start;
            if (A[mid] < 0) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] < 0) {
            return end + 1;
        } else if (A[start] < 0) {
            return start + 1;
        } else {
            return 0;
        }
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
