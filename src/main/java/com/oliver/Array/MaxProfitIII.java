package com.oliver.Array;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.Array.ArrayUtils.maxInArray;

/**
 * Created by Yanliang Han on 2016/7/15.
 */
public class MaxProfitIII {
    private final static Logger logger = LoggerFactory.getLogger(MaxProfitIII.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMaxProfitIII();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMaxProfitIII() {
        logger.info("result1 = {}", maxProfit(new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
        logger.info("result2 = {}", maxProfit(new int[]{2, 2, 3, 4, 1, 2, 1, 5, 3}));
        logger.info("result3 = {}", maxProfit(new int[]{3, 2, 3, 1, 2}));
        logger.info("result4 = {}", maxProfit(new int[]{2, 1, 2, 0, 1}));
    }

    public static int maxProfitI(List<Integer> prices) {
        if (prices == null || prices.size() < 2) {
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

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int len = prices.length;
        ArrayList<Integer> list = new ArrayList<Integer>(len);
        for (int price : prices) {
            list.add(price);
        }

        int[] ret = new int[len];
        ret[0] = maxProfitI(list);
        for (int i = 1; i < len; i++) {
            ret[i] = maxProfitI(list.subList(0, i)) + maxProfitI(list.subList(i, len));
        }

//        logger.info("ret = {}", Arrays.toString(ret));
        return maxInArray(ret);
    }
}
