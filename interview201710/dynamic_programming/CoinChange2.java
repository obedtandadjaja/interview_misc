/*
You are given coins of different denominations and a total amount of money amount.
Write a function to compute the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 */

import java.lang.Math;

class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = new int[] { 1,2,5,10 };
        int amount = 125;
        System.out.println(coinChange(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        getChange(coins, dp, amount);
        return dp[amount];
    }

    public static int getChange(int[] coins, int[] dp, int amount) {
        if(amount < 0) return -1;
        else if(amount == 0) return 0;
        else if(dp[amount] != 0) return dp[amount];
        else {
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < coins.length; i++) {
                int numOfChange = getChange(coins, dp, amount-coins[i]);
                if(numOfChange != -1) min = Math.min(min, numOfChange);
            }

            dp[amount] = min == Integer.MAX_VALUE ? -1 : min + 1;
            return dp[amount];
        }
    }
}
