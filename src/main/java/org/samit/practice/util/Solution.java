package org.samit.practice.util;

class Solution {

    public static void main(String[] args) {
        System.out.println("result : " + numberSeq(10, 4));
    }

    static int numberSequence(int m, int n) {

        if (m < n) return 0;
        if (n == 0) return 1;


        return numberSequence(m - 1, n) + numberSequence(m / 2, n - 1);
    }

    static int numberSeq(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i / 2][j - 1];
            }
        }

        return dp[m][n];
    }
}