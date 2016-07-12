package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class HasCycle {
    private final static Logger logger = LoggerFactory.getLogger(HasCycle.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testHasCycle();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testHasCycle() {
        ListNode head = new ListNode(8);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        logger.info("{}", hasCycle(head));

        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        logger.info("{}", hasCycle(head2));

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(2);
        logger.info("{}", hasCycle(head3));

        ListNode head4 = new ListNode(-21);
        head4.next = new ListNode(10);
        head4.next.next = new ListNode(4);
        head4.next.next.next = new ListNode(5);
        head4.next.next.next.next = head4;
        logger.info("{}", hasCycle(head4));

        logger.info("{}", hasCycle(null));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}
