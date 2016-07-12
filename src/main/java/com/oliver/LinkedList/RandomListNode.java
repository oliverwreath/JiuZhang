package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class RandomListNode {
    private final static Logger logger = LoggerFactory.getLogger(RandomListNode.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + next.toValueString() +
                ", random=" + random.toValueString() +
                '}';
    }

    public String toLongString() {
        return "RandomListNode{" +
                "label=" + label +
                ", next=" + next +
                ", random=" + random +
                '}';
    }

    public String toValueString() {
        return "RandomListNode{" +
                "label=" + label +
                '}';
    }
}
