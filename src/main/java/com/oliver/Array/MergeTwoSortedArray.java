package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/13.
 */
public class MergeTwoSortedArray {
    private final static Logger logger = LoggerFactory.getLogger(MergeTwoSortedArray.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMergeTwoSortedArray();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMergeTwoSortedArray() {
        int[] result1 = mergeTwoSortedArray(new int[]{1, 2, 3, 4}, new int[]{2, 4, 5, 6});
        logger.info("result1 = {}", result1);
    }

    public static int[] mergeTwoSortedArray(int[] A, int[] B) {
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        int m = A.length;
        int n = B.length;
        int len = m + n;
        int[] ret = new int[len];
        int i = 0, j = 0, k = 0;

        for (; i < m && j < n; ) {
            if (A[i] < B[j]) {
                ret[k++] = A[i++];
            } else {
                ret[k++] = B[j++];
            }
        }

        if (i < m) {
            while (i < m) {
                ret[k++] = A[i++];
            }
        } else if (j < n) {
            while (j < n) {
                ret[k++] = B[j++];
            }
        }

        return ret;
    }
}
//给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
