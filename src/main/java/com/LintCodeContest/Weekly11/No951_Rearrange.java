package com.LintCodeContest.Weekly11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No951_Rearrange {
    private static final Logger logger = LoggerFactory.getLogger(No951_Rearrange.class);

    public static void main(String[] args) {
        No951_Rearrange No951_Rearrange = new No951_Rearrange();
        No951_Rearrange.testNo951_Rearrange();
    }

    private void testNo951_Rearrange() {
        MyLogger.info("result [-1,1,-1,5,0,10] v.s. " + Arrays.toString(rearrange(new int[]{-1, 0, 1, -1, 5, 10})));
        MyLogger.info("result [-1,2,0,5,1,10] v.s. " + Arrays.toString(rearrange(new int[]{2, 0, 1, -1, 5, 10})));
        MyLogger.info("result [-1,2,0,5,1] v.s. " + Arrays.toString(rearrange(new int[]{2, 0, 1, -1, 5})));
    }

    int[] rearrange(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return A;
        }

        int len = A.length;
        int[] answer = new int[len];
        Arrays.sort(A);
        int mid = (len + 1) / 2;
        for (int i = 0, j = 0; i < mid; i++, j += 2) {
            answer[j] = A[i];
        }
        for (int i = mid, j = 1; i < len; i++, j += 2) {
            answer[j] = A[i];
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
