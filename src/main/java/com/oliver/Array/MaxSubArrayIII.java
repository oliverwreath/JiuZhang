package com.oliver.Array;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.intArray2List;
import static com.oliver.Array.ArrayUtils.maxInArray;

/**
 * Created by Yanliang Han on 2016/7/16.
 */
public class MaxSubArrayIII {
    private final static Logger logger = LoggerFactory.getLogger(MaxSubArrayIII.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxSubArrayIII();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxSubArrayIII() {
        logger.info("result1 = {}", maxSubArray(new int[]{-1, 4, -2, 3, -2, 3}, 2));
        logger.info("result2 = {}", maxSubArray(new int[]{1, 3, -1, 2, -1, 2}, 2));
        logger.info("result3 = {}", maxSubArray(new int[]{3, 2, 3, 1, 2}, 2));
        logger.info("result4 = {}", maxSubArray(new int[]{2, 1, 2, 0, 1}, 2));
    }

    public static int maxSubArrayHelper(List<Integer> list) {
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

    public static int maxSubArray(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        List<Integer> list = intArray2List(nums);

        int len = list.size();
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, maxSubArrayHelper(list.subList(0, i)) + maxSubArrayHelper(list.subList(i, len)));
        }

        return max;
    }
}
