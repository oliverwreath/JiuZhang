package com.oliver.LinkedList;

import com.oliver.LinkedList.DeleteDuplicates.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class ReverseBetween {
    private final static Logger logger = LoggerFactory.getLogger(ReverseBetween.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testReverseBetween();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testReverseBetween() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        logger.info("result = {}", reverseBetween(head, 1, 1));
        logger.info("result = {}", reverseBetween(head, 2, 4));
        logger.info("result = {}", reverseBetween(head, 3, 5));
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m < 0 || n < 0) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            head = head.next;
        }
//        logger.info("head = {}", head);

        n = n - m;
        m = 0;
        while (m < n) {
//            logger.info("m = {}, n = {}", m, n);
            int tmp = head.val;
            ListNode right = head;
            for (int i = 0; i < n; i++) {
                right = right.next;
            }
            head.val = right.val;
            right.val = tmp;

            n -= 2;
            head = head.next;
        }

        return dummy.next;
    }
}
