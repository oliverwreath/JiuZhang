package com.oliver.Array;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.*;

/**
 * Created by Yanliang Han on 2016/7/16.
 */
public class MaxDiffSubArrays {
    private final static Logger logger = LoggerFactory.getLogger(MaxDiffSubArrays.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxDiffSubArrays();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxDiffSubArrays() {
        logger.info("result1 = {}", maxDiffSubArrays(new int[]{-1, 4, -2}));
        logger.info("result2 = {}", maxDiffSubArrays(new int[]{1, 2, -3, 1}));
        logger.info("result3 = {}", maxDiffSubArrays(new int[]{3, 2, 3, 1, 2}));
        logger.info("result4 = {}", maxDiffSubArrays(new int[]{2, 1, 2, 0, 1}));
    }

    public static int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() < 1) {
            return 0;
        }

        int len = nums.size();
        int[] s = new int[len];
        s[0] = nums.get(0);
        for (int i = 1; i < len; i++) {
            if (s[i - 1] <= 0) {
                s[i] = s[i - 1] + nums.get(i);
            } else {
                s[i] = nums.get(i);
            }
        }

        return minInArray(s);
    }

    public static int maxSubArray(List<Integer> nums) {
        if (nums == null || nums.size() < 1) {
            return 0;
        }

        int len = nums.size();
        int[] s = new int[len];
        s[0] = nums.get(0);
        for (int i = 1; i < len; i++) {
            if (s[i - 1] >= 0) {
                s[i] = s[i - 1] + nums.get(i);
            } else {
                s[i] = nums.get(i);
            }
        }

//        logger.info("s = {}", s);
        return maxInArray(s);
    }

    public static int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        List<Integer> list = intArray2List(nums);
        int len = list.size();
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            maxDiff = Math.max(maxDiff, maxSubArray(list.subList(0, i)) - minSubArray(list.subList(i, len)));
            maxDiff = Math.max(maxDiff, maxSubArray(list.subList(i, len)) - minSubArray(list.subList(0, i)));
        }

        return maxDiff;
    }
}
