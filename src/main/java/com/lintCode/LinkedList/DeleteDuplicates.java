package com.lintCode.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/10.
 */
public class DeleteDuplicates {
    private static final Logger logger = LoggerFactory.getLogger(DeleteDuplicates.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testDeleteDuplicates();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testDeleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        logger.info("{}", deleteDuplicates(head));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        logger.info("{}", deleteDuplicates(head2));

        ListNode head3 = new ListNode(1);
        logger.info("{}", deleteDuplicates(head3));

        logger.info("{}", deleteDuplicates(null));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val) {
                // duplication detected
                int duplicatedValue = head.next.val;
                while (head.next != null && head.next.val == duplicatedValue) {
                    head.next = head.next.next;
                }
            } else {
                // unique element
                head = head.next;
            }
        }

        return dummy.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                // duplication detected
                fast = fast.next;
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                slow.next = fast;
            } else {
                // unique element
                fast = fast.next;
                slow = slow.next;
            }
        }

        return dummy.next;
    }
}
