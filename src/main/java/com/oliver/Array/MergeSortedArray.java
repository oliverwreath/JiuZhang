package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/13.
 */
public class MergeSortedArray {
    private final static Logger logger = LoggerFactory.getLogger(MergeSortedArray.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMergeSortedArray();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMergeSortedArray() {
        int[] A = new int[]{1, 2, 3, -1, -1};
        mergeSortedArray(A, 3, new int[]{4, 5}, 2);
        logger.info("result1 = {}", A);
    }

    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (B == null || B.length < 1) {
            return;
        }

        int len = m + n;
        int i = m - 1, j = n - 1, k = len - 1;
        for (; i >= 0 && j >= 0 && k >= 0; ) {
            if (A[i] > B[j]) {
                A[k--] = A[i--];
            } else {
                A[k--] = B[j--];
            }
        }

        if (i >= 0) {
            while (i >= 0) {
                A[k--] = A[i--];
            }
        } else if (j >= 0) {
            while (j >= 0) {
                A[k--] = B[j--];
            }
        }

        return;
    }
}
//A = [1, 2, 3, empty, empty], B = [4, 5]
//        After merge, A will be filled as [1, 2, 3, 4, 5]