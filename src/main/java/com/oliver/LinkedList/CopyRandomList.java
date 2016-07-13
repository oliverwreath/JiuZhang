package com.oliver.LinkedList;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.LinkedList.ListUtils.getRandomList;

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
        RandomListNode head = getRandomList(new int[]{2, 3, 3, 4, 4, 5});
        logger.info("{}", copyRandomList(head));

        RandomListNode head2 = getRandomList(new int[]{8, 1, 1, 2, 3});
        logger.info("{}", copyRandomList(head2));

        RandomListNode head3 = getRandomList(new int[]{1, 3, 2});
        logger.info("{}", copyRandomList(head3));

        RandomListNode head4 = getRandomList(new int[]{-21, 10, 4, 5});
        head4.next.next.next.next = head4;
        logger.info("{}", copyRandomList(head4));

        logger.info("{}", copyRandomList(null));
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode dummy = new RandomListNode(0);
        dummy.next = head;

        while (head != null) {
            map.put(head, head.random);
            head = head.next;
        }

        head = dummy.next;
        RandomListNode dummyNew = new RandomListNode(0);
        RandomListNode headNew = dummyNew;
        while (head != null) {
            headNew.next = new RandomListNode(head.label);
            headNew = headNew.next;
            headNew.next.random = map.get(head);
            head = head.next;
        }

        return dummyNew.next;
    }
}
