package com.ATemplates_DataStructures.UnionFind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class No434_NumberOfIslandsII {
    private static final Logger logger = LoggerFactory.getLogger(No434_NumberOfIslandsII.class);

    public static void main(String[] args) {
        No434_NumberOfIslandsII No434_NumberOfIslandsII = new No434_NumberOfIslandsII();
        No434_NumberOfIslandsII.testNo434_NumberOfIslandsII();
    }

    private void testNo434_NumberOfIslandsII() {
        MyLogger.info("result 2 v.s. " + numIslands2(3, 3, new Point[]{
                new Point(0, 0),
                new Point(0, 1),
                new Point(2, 2),
                new Point(2, 1)
        }));
    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    List<Integer> numIslands2(int m, int n, Point[] islands) {
        // filter abnormal cases
        answer = new ArrayList<>();
        if (islands == null || islands.length == 0) {
            return answer;
        }
        UnionFind unionFind = new UnionFind(m, n);
        for (Point island : islands) {
            unionFind.add(island);
            answer.add(unionFind.count);
        }

        // return the final result
        return answer;
    }

    List<Integer> answer;

    class UnionFind {
        int m;
        int n;
        int count;
        int[] map;
        boolean[][] grid;

        public UnionFind(int m, int n) {
            this.m = m;
            this.n = n;
            this.count = 0;
            this.map = new int[m * n];
            for (int id = 0; id < m * n; id++) {
                map[id] = id;
            }
            this.grid = new boolean[m][n];
        }

        public int getId(int x, int y) {
            return x * n + y;
        }

        public void union(int x, int y) {
            int xBoss = find(x);
            int yBoss = find(y);
            if (map[xBoss] != yBoss) {
                count--;
            }
            map[xBoss] = yBoss;
        }

        public int find(int x) {
            if (map[x] == x) {
                return x;
            }
            int t = x;
            while (map[t] != t) {
                t = map[t];
            }
            map[x] = t;
            return t;
        }

        public void add(Point island) {
            if (grid[island.x][island.y]) {
                return;
            }
            int i = island.x;
            int j = island.y;
            grid[i][j] = true;
            count++;
            if (i - 1 >= 0 && grid[i - 1][j]) {
                union(getId(i, j), getId(i - 1, j));
            }
            if (i + 1 < m && grid[i + 1][j]) {
                union(getId(i, j), getId(i + 1, j));
            }
            if (j - 1 >= 0 && grid[i][j - 1]) {
                union(getId(i, j), getId(i, j - 1));
            }
            if (j + 1 < n && grid[i][j + 1]) {
                union(getId(i, j), getId(i, j + 1));
            }
        }
    }


    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
