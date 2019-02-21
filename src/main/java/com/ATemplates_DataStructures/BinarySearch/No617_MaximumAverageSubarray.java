package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No617_MaximumAverageSubarray {
    private static final Logger logger = LoggerFactory.getLogger(No617_MaximumAverageSubarray.class);

    public static void main(String[] args) {
        testNo141_SqrtX();
    }

    private static void testNo141_SqrtX() {
        No617_MaximumAverageSubarray No141_SqrtX = new No617_MaximumAverageSubarray();
        MyLogger.info("result 15.667 v.s. " + No141_SqrtX.maxAverage(new int[]{1, 12, -5, -6, 50, 3}, 3));
//        MyLogger.info("result 10 v.s. " + No141_SqrtX.maxAverage(new int[]{5, 5, 4, 3, 2, 1}, 2));
    }

    public double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        double start = nums[0];
        double end = nums[0];
        for (int num : nums) {
            start = Math.min(start, num);
            end = Math.max(end, num);
        }

        while (1e-12 < end - start) {
            double mid = (end - start) / 2 + start;
            if (isValid(mid, nums, k)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return start;
    }

    boolean isValid(double bar, int[] nums, int k) {
        // bar <= actual avg
        double preMin = 0;
        int len = nums.length;
        double[] sum = new double[len + 1];
        sum[0] = 0;
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] - bar;
            if (i >= k) {
                if (sum[i] - preMin >= 0) {
                    return true;
                }
                preMin = Math.min(preMin, sum[i - k + 1]);
            }
        }

        return false;
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
