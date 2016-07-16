package com.oliver.Array;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.intArray2List;
import static com.oliver.Array.ArrayUtils.maxInArray;

/**
 * Created by Yanliang Han on 2016/7/16.
 */
public class MaxTwoSubArrays {
    private final static Logger logger = LoggerFactory.getLogger(MaxTwoSubArrays.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxTwoSubArrays();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxTwoSubArrays() {
        logger.info("result1 = {}", maxTwoSubArrays(intArray2List(new int[]{4, 4, 6, 1, 1, 4, 2, 5})));
        logger.info("result2 = {}", maxTwoSubArrays(intArray2List(new int[]{1, 3, -1, 2, -1, 2})));
        logger.info("result3 = {}", maxTwoSubArrays(intArray2List(new int[]{3, 2, 3, 1, 2})));
        logger.info("result4 = {}", maxTwoSubArrays(intArray2List(new int[]{2, 1, 2, 0, 1})));
    }

    public static int maxSubArray(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return 0;
        }

        int[] s = new int[list.size()];
        s[0] = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (s[i - 1] >= 0) {
                s[i] = s[i - 1] + list.get(i);
            } else {
                s[i] = list.get(i);
            }
        }

//        logger.info("s = {}", s);
        return maxInArray(s);
    }

    public static int maxTwoSubArrays(List<Integer> nums) {
        if (nums == null || nums.size() < 1) {
            return 0;
        }

        int len = nums.size();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, maxSubArray(nums.subList(0, i)) + maxSubArray(nums.subList(i, len)));
        }

        return max;
    }
}
