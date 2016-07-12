package com.oliver.LinkedList;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oliver.LinkedList.ListUtils.getList;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class MergeKLists {
    private final static Logger logger = LoggerFactory.getLogger(MergeKLists.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testMergeKLists();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testMergeKLists() {
        ListNode head1 = getList(new int[]{-2, 4, 6, 8, 10});

        ListNode head2 = getList(new int[]{-3, 5, 7, 11});
        List<ListNode> lists = new LinkedList<ListNode>();
        lists.add(head1);
        lists.add(head2);
        logger.info("{}", mergeKLists(lists));

        ListNode head3 = getList(new int[]{-33, -22, 99});
        lists.add(head3);
        logger.info("{}", mergeKLists(lists));

        lists.add(null);
        logger.info("{}", mergeKLists(lists));

        lists.clear();
        lists.add(new ListNode(2));
        lists.add(null);
        lists.add(new ListNode(-1));
        logger.info("{}", mergeKLists(lists));

        logger.info("{}", mergeKLists(new LinkedList<ListNode>()));

        logger.info("{}", mergeKLists(null));
    }

    public static ListNode merge2Lists(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }
        if (head1 != null) {
            head.next = head1;
        } else if (head2 != null) {
            head.next = head2;
        }

        return dummy.next;
    }

    public static void mergeRound(RangeType rangeType, List<ListNode> lists) {
//        logger.info("RangeType = {}", rangeType);
        while (rangeType.start < rangeType.end) {
            ListNode tmp = merge2Lists(lists.get(rangeType.start), lists.get(rangeType.end));
            lists.set(rangeType.start, tmp);
            lists.remove(rangeType.end);
            rangeType.start++;
            rangeType.end--;
        }
        rangeType.start = 0;
    }

    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() < 1) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }

        int len = lists.size();
        RangeType rangeType = new RangeType(0, len - 1);
        while (rangeType.getEnd() > 0) {
            mergeRound(rangeType, lists);
        }

        return lists.get(0);
    }

    private static class RangeType {
        int start;
        int end;

        public RangeType(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "RangeType{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
