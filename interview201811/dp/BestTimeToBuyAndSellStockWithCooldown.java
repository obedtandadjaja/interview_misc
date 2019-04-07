/*
  Difficulty: Medium

  Say you have an array for which the ith element is the price of a given stock on day i.

  Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

  You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
  After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
  Example:

  Input: [1,2,3,0,2]
  Output: 3
  Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */

class Solution {
  // 1: dp
  public int maxProfit(int[] prices) {
    if(prices.length == 0) return 0;

    int[] dp = new int[prices.length];

    dp[0] = 0;
    for(int i = 1; i < prices.length; i++) {
      int maxProfit = 0;

      // backtrack to find the lowest day
      for(int j = i - 1; j >= 0 && prices[j] < prices[i]; j--) {
        // previous profit is 2 days before
        int prevProfit = j >= 2 ? dp[j - 2] : 0;

        // calculate the max profit considering the previous profit
        maxProfit = Math.max(maxProfit, prices[i] - prices[j] + prevProfit);
      }

      dp[i] = Math.max(maxProfit, dp[i - 1]);
    }

    return dp[prices.length - 1];
  }

  // 2: recursion
  public int maxProfit(int[] prices) {
    return helper(prices, 0, false);
  }

  public int helper(int[] prices, int current, boolean cooldown) {
    if(current == prices.length) return 0;

    if(cooldown) {
      return helper(memo, prices, current + 1, false);
    } else {
      int maxProfit = 0;

      for(int i = current; i < prices.length; i++) {
        for(int j = i + 1; j < prices.length; j++) {
          if(prices[i] < prices[j]) {
            int potentialProfit = helper(prices, j + 1, true) + (prices[j] - prices[i]);

            maxProfit = Math.max(maxProfit, potentialProfit);
          }
        }
      }

      return maxProfit;
    }
  }
}
