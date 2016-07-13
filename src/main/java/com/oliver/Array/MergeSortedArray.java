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
        int[] result1 = mergeSortedArray(new int[]{1, 2, 3, 4}, new int[]{2, 4, 5, 6});
        logger.info("result1 = {}", result1);
    }

    public static int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        int lenA = A.length;
        int lenB = B.length;
        int len = lenA + lenB;
        int[] ret = new int[len];
        int i = 0, j = 0, k = 0;

        for (; i < lenA && j < lenB; ) {
            if (A[i] < B[j]) {
                ret[k++] = A[i++];
            } else {
                ret[k++] = B[j++];
            }
        }

        if (i < lenA) {
            while (i < lenA) {
                ret[k++] = A[i++];
            }
        } else if (j < lenB) {
            while (j < lenB) {
                ret[k++] = B[j++];
            }
        }

        return ret;
    }
}
//给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
