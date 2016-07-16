package com.oliver.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/15.
 */
public class MaxProfitII {
    private final static Logger logger = LoggerFactory.getLogger(MaxProfitII.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testmaxProfitII();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testmaxProfitII() {
        logger.info("result1 = {}", maxProfit(new int[]{3, 2, 3, 1, 2}));
        logger.info("result2 = {}", maxProfit(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
        logger.info("result3 = {}", maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 1) {
            return 0;
        }

        int len = prices.length;
        int ret = 0;
        boolean is_bought = false;
        for (int i = 0; i < len - 1; i++) {
            if (!is_bought) {
                if (prices[i] < prices[i + 1]) {
                    ret -= prices[i];
                    is_bought = true;
//                    logger.info("i = {}, ret = {}, is_bought={}", i, ret, is_bought);
                }
            } else {
                if (prices[i] > prices[i + 1]) {
                    ret += prices[i];
                    is_bought = false;
//                    logger.info("i = {}, ret = {}, is_bought={}", i, ret, is_bought);
                }
            }
        }

        if (is_bought) {
            ret += prices[len - 1];
//            logger.info("ret = {}, is_bought={}", ret, is_bought);
        }

        return ret;
    }
}
