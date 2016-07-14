package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/14.
 */
public class MaxSubArray {
    private final static Logger logger = LoggerFactory.getLogger(MaxSubArray.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxSubArray();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxSubArray() {
        logger.info("result1 = {}", maxSubArray(new int[]{3, 2, 3, 1, 2}));
        logger.info("result2 = {}", maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int[] s = new int[nums.length];
        s[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (s[i - 1] >= 0) {
                s[i] = s[i - 1] + nums[i];
            } else {
                s[i] = nums[i];
            }
        }

//        logger.info("s = {}", s);
        return maxInArray(s);
    }

    public static int maxInArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }
}
