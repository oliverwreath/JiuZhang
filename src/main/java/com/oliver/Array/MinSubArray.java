package com.oliver.Array;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.intArray2List;
import static com.oliver.Array.ArrayUtils.minInArray;

/**
 * Created by Yanliang Han on 2016/7/16.
 */
public class MinSubArray {
    private final static Logger logger = LoggerFactory.getLogger(MinSubArray.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMinSubArray();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMinSubArray() {
        logger.info("result1 = {}", minSubArray(intArray2List(new int[]{-1, 4, -2})));
        logger.info("result2 = {}", minSubArray(intArray2List(new int[]{1, 3, -1, 2, -1, 2})));
        logger.info("result3 = {}", minSubArray(intArray2List(new int[]{3, 2, 3, 1, 2})));
        logger.info("result4 = {}", minSubArray(intArray2List(new int[]{2, 1, 2, 0, 1})));
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
}
