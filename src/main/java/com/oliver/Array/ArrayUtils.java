package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/13.
 */
public class ArrayUtils {
    private final static Logger logger = LoggerFactory.getLogger(ArrayUtils.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testArrayUtils();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static void insertionSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }
//        logger.info("nums = {}", nums);

        int len = nums.length;
        for (int start = 0; start < len - 1; start++) {
            int min = nums[start];
            int minIndex = start;
            for (int i = start + 1; i < len; i++) {

                if (nums[i] < min) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            int tmp = nums[start];
            nums[start] = nums[minIndex];
            nums[minIndex] = tmp;
        }

//        logger.info("nums = {}", nums);
        return;
    }

    private static void testArrayUtils() {
        ArrayUtils();
    }

    public static void ArrayUtils() {

    }
}
