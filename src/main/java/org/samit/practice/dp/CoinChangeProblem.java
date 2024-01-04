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
        System.out.println("Answer with dp solution : " + ccp.coinChangeDpSolution(coins, sum));
    }

    private int coinChangeRecursive(int[] coins, int sum, int i) {

        if (sum == 0)
            return 1;

        if (sum < 0 || i == 0)
            return 0;

        return coinChangeRecursive(coins, sum, i - 1) + coinChangeRecursive(coins, sum - coins[i-1], i);
    }

    /**
     * Time : O(n*sum) , Aux space : O(n*sum)
     * @param coins
     * @param sum
     * @return
     */
    private int coinChangeDpSolution(int[] coins, int sum){
        int[][] tab = new int[coins.length + 1][sum+1];
        int n = coins.length;
        // init tab with base cases
        // if sum = 0 , then tab[i][0] is 1
        // if i = 0 and sum > 0 then tab[0][j] = 0
        for(int i=0; i < n+1; i++ ){
            tab[i][0] = 1;
        }

        for(int i = 1; i < n+1; i++){
            for(int j=1; j < sum+1; j++){
                if(coins[i-1] > j)
                    tab[i][j] = tab[i-1][j];
                else{
                    tab[i][j] = tab[i-1][j] + tab[i][j-coins[i-1]];
                }
            }
        }
        return tab[n][sum];
    }

}
