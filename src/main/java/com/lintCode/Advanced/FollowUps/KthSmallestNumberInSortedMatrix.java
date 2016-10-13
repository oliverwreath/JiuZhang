package com.lintCode.Advanced.FollowUps;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class KthSmallestNumberInSortedMatrix {
    private final static Logger logger = LoggerFactory.getLogger(KthSmallestNumberInSortedMatrix.class);

    public static void main(String[] arg) {
        new KthSmallestNumberInSortedMatrix().testKthLargestInNArrays();
    }

    private void testKthLargestInNArrays() {
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 1));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 2));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 3));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 4));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 5));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 6));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 7));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 8));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 9));
        logger.info("{}", kthSmallest(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 10));

        logger.info("{}", kthSmallest(new int[][]{{9, 3, 2, 4, 7}, {1, 2, 3, 4, 8}}, 3));
        logger.info("{}", kthSmallest(new int[][]{{9, 3, 2, 4, 8}, {1, 2, 3, 4, 2}}, 1));
    }

    /**
     * @param matrix: a matrix of integers
     * @param k:      an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        // handle extreme cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return -1;
        }
        if (k == 0) {
            return -1;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(n, cellComparator);
        for (int i = 0; i < n; i++) {
            heap.add(new Cell(matrix[i][0], i, 0));
        }
        for (int i = k; i > 1; i--) {
            Cell poll = heap.poll();
            if (poll.y < m - 1) {
                heap.add(new Cell(matrix[poll.x][poll.y + 1], poll.x, poll.y + 1));
            }
        }

        if (heap.isEmpty()) {
            return -1;
        } else {
            return heap.poll().val;
        }
    }

    Comparator<Cell> cellComparator = new Comparator<Cell>() {
        public int compare(Cell o1, Cell o2) {
            return o1.val - o2.val;
        }
    };

    private class Cell {
        int val;
        int x;
        int y;

        public Cell() {
        }

        public Cell(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
