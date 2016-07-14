package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/14.
 */
public class MaxProfit {
    private final static Logger logger = LoggerFactory.getLogger(MaxProfit.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxProfit();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxProfit() {
        logger.info("result1 = {}", maxProfit(new int[]{3, 2, 3, 1, 2}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price - minCost > maxProfit) {
                maxProfit = price - minCost;
            }
            minCost = Math.min(minCost, price);
        }

        return maxProfit;
    }
}
