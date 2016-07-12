package com.oliver.LinkedList;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next.toValueString() +
                '}';
    }

    public String toLongString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public String toValueString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
