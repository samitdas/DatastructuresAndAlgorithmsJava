package org.samit.practice.dp;

/**
 * Given infinite supply of given set of coins and a sum find the total combinations such that sum of each combination is equal to the given sum
 * given coins [1,2,3] and sum 4 answer is 4 [[1,1,1,1], [2,2], [3,1], [2,1,1]]
 */
public class CoinChangeProblem {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 4;
        CoinChangeProblem ccp = new CoinChangeProblem();
        System.out.println("Answer with recursive solution : " + ccp.coinChangeRecursive(coins, sum, coins.length));
    }

    private int coinChangeRecursive(int[] coins, int sum, int i) {

        if (sum == 0)
            return 1;

        if (sum < 0 || i == 0)
            return 0;

        return coinChangeRecursive(coins, sum, i - 1) + coinChangeRecursive(coins, sum - coins[i-1], i);
    }
}
