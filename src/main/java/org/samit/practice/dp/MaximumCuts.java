package org.samit.practice.dp;

import static org.samit.practice.util.DsUtil.findMax;

/**
 * Given a rope of length n and cut size array, find max number of cuts possible so that each cut is any of the
 * given elements in the array. Multiple cut of same size is allowed
 */
public class MaximumCuts {

    public static void main(String[] args) {
        MaximumCuts mct = new MaximumCuts();
        System.out.println("max cuts possible using recursion : " + mct.maxCutsRecursive(5, 1, 2, 3));
        System.out.println("max cuts possible using dp : " + mct.maxCutsDp(5, 1, 2, 3));
    }

    private int maxCutsRecursive(int n, int a, int b, int c) {

        if (n < 0) return -1;
        if (n == 0) return 0;

        int res = findMax(maxCutsRecursive(n - a, a, b, c),
                maxCutsRecursive(n - b, a, b, c),
                maxCutsRecursive(n - c, a, b, c));

        if (res == -1)
            return -1;

        return res + 1;
    }

    private int maxCutsDp(int n, int a, int b, int c){
        int[] dp = new int[n+1];
        dp[0] = 0;

        for(int i = 1; i <= n ; i++){
            dp[i] = -1;
            if(i-a >= 0)
                dp[i] = Math.max(dp[i], dp[i-a]);
            if(i-b >= 0)
                dp[i] = Math.max(dp[i], dp[i-b]);
            if(i-c >= 0)
                dp[i] = Math.max(dp[i], dp[i-c]);

            if(dp[i] != -1)
                dp[i] = dp[i]+1;
        }

        return dp[n];
    }
}
