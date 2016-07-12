package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class CopyRandomList {
    private final static Logger logger = LoggerFactory.getLogger(CopyRandomList.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testCopyRandomList();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testCopyRandomList() {
//        copyRandomList(head);
    }

//    public static RandomListNode copyRandomList(RandomListNode head) {
//
//    }
}
