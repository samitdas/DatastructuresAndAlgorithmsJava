package org.samit.practice.dp;

/**
 * Given a value and array of coins (infinite supply) find the minimum number of coins required to get the given sum
 * val = 5, arr = [1,3,4] answer would be 2 (4,1)
 */
public class MinimumCoins {
    public static void main(String[] args) {
        MinimumCoins mcs = new MinimumCoins();
        System.out.println("answer using recursive : " + mcs.minCoinsRecursive(new int[]{1, 3, 4}, 5));
        System.out.println("answer using dp : " + mcs.minCoinsDpSolution(new int[]{1, 3, 4}, 5));
    }

    /**
     * for each coin less than the given value, recur with the new value as val - coins[i] and take the minimum result
     *
     * @param coins
     * @param val
     * @return
     */
    private int minCoinsRecursive(int[] coins, int val) {

        if (val == 0) return 0;
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= val) {
                int subResult = minCoinsRecursive(coins, val - coins[i]);
                if (subResult != Integer.MAX_VALUE) {
                    res = Math.min(res, subResult + 1);
                }
            }
        }

        return res;
    }

    /**
     * Array is of size val. dp[i] denotes the min coins required to get value i
     * @param coins
     * @param val
     * @return
     */
    private int minCoinsDpSolution(int[] coins, int val) {
        int[] dp = new int[val + 1];
        dp[0] = 0;

        for(int i=1 ; i <= val; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                }
            }
        }

        return dp[val];
    }

}
