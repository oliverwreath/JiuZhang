package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class RotateRight {
    private final static Logger logger = LoggerFactory.getLogger(RotateRight.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testRotateRight();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testRotateRight() {
        ListNode head = new ListNode(8);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        logger.info("{}", rotateRight(head, 2));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        logger.info("{}", rotateRight(head2, 2));

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(2);
        logger.info("{}", rotateRight(head3, 3));

        ListNode head4 = new ListNode(-21);
        head4.next = new ListNode(10);
        head4.next.next = new ListNode(4);
        head4.next.next.next = new ListNode(5);
        logger.info("{}", rotateRight(head4, 1));

        logger.info("{}", rotateRight(null, 0));
    }

    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public static ListNode getHeadK(ListNode head, int k) {
        for (int i = 0; i < k - 1; i++) {
            head = head.next;
        }

        return head;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = getLength(head);
        k %= len;

        if (k == 0) {
            return head;
        } else {
            ListNode leftTail = getHeadK(head, len - k);
            ListNode headRight = leftTail.next;
            leftTail.next = null;
            ListNode rightTail = headRight;

            while (rightTail != null && rightTail.next != null) {
                rightTail = rightTail.next;
            }
            rightTail.next = head;

            return headRight;
        }
    }
}
