package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.LinkedList.ListUtils.getList;

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
        ListNode head = getList(new int[]{2, 3, 3, 4, 4, 5});
        logger.info("{}", hasCycle(head));

        ListNode head2 = getList(new int[]{8, 1, 1, 2, 3});
        logger.info("{}", hasCycle(head2));

        ListNode head3 = getList(new int[]{1, 3, 2});
        logger.info("{}", hasCycle(head3));

        ListNode head4 = getList(new int[]{-21, 10, 4, 5});
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
