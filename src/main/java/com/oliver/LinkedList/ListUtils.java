package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class ListUtils {
    private final static Logger logger = LoggerFactory.getLogger(ListUtils.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        testListUtils();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static ListNode getList(int[] values) {
        if (values == null) {
            return null;
        }

        int len = values.length;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < len; i++) {
            head.next = new ListNode(values[i]);
            head = head.next;
        }

        return dummy.next;
    }

    private static void testListUtils() {
        ListUtils();
    }

    public static void ListUtils() {

    }
}
