package com.ATemplates_DataStructures.DP.PiPeiLei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class No623_KEditDistance {
    private static final Logger logger = LoggerFactory.getLogger(No623_KEditDistance.class);

    public static void main(String[] args) {
        No623_KEditDistance No623_KEditDistance = new No623_KEditDistance();
        No623_KEditDistance.testNo623_KEditDistance();
    }

    private void testNo623_KEditDistance() {
        MyLogger.info("result [\"abc\",\"adc\"] v.s. " + kDistance(new String[]{"abc", "abd", "abcd", "adc"}, "ac", 1));
    }

    public List<String> kDistance(String[] words, String target, int k) {
        // filter abnormal cases
        List<String> answers = new LinkedList<>();
        if (words == null || words.length == 0) {
            return answers;
        }

        for (String word : words) {
            if (minDistance(word, target) <= k) {
                answers.add(word);
            }
        }

        // return the final result
        return answers;
    }

    public int minDistance(String A, String B) {
        // filter abnormal cases
        if (A == null || A.length() == 0) {
            return B == null ? 0 : B.length();
        }
        if (B == null || B.length() == 0) {
            return A == null ? 0 : A.length();
        }

        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (A.charAt(i - 1) == B.charAt(j - 1)) {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
                    } else {
                        dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
                    }
                }
            }
        }

        // return the final result
        return dp[m][n];
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
