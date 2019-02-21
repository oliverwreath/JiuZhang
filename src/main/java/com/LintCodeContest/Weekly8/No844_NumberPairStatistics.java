package com.LintCodeContest.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No844_NumberPairStatistics {
    private static final Logger logger = LoggerFactory.getLogger(No844_NumberPairStatistics.class);

    public static void main(String[] args) {
        No844_NumberPairStatistics No844_NumberPairStatistics = new No844_NumberPairStatistics();
        No844_NumberPairStatistics.testNo844_NumberPairStatistics();
    }

    private void testNo844_NumberPairStatistics() {
        Point[] tmp = new Point[]{
                new Point(1, 2), new Point(3, 4), new Point(5, 6)
        };
        MyLogger.info("result 3 v.s. " + pairNumbers(tmp));
        Point[] tmp2 = new Point[]{
                new Point(0, 3), new Point(1, 1), new Point(3, 4), new Point(5, 6)
        };
        MyLogger.info("result 1 v.s. " + pairNumbers(tmp2));
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int pairNumbers(Point[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int answer = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if ((A[i].x + A[j].x) % 2 == 0 && (A[i].y + A[j].y) % 2 == 0) {
                    answer++;
                }
            }
        }

        // return the final result
        return answer;
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
