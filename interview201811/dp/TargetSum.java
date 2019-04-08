/*
  Difficulty: Medium

  You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

  Find out how many ways to assign symbols to make sum of integers equal to target S.

  Example 1:
  Input: nums is [1, 1, 1, 1, 1], S is 3.
  Output: 5
  Explanation:

  -1+1+1+1+1 = 3
  +1-1+1+1+1 = 3
  +1+1-1+1+1 = 3
  +1+1+1-1+1 = 3
  +1+1+1+1-1 = 3

  There are 5 ways to assign symbols to make the sum of nums be target 3.
  Note:
  The length of the given array is positive and will not exceed 20.
  The sum of elements in the given array will not exceed 1000.
  Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

class Solution {
  // 1: recursion with memoization
  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for(int num : nums)
      sum += num;

    if(S > sum || S < -sum) return 0;

    // create memo of nums length with cols to keep -sum to sum
    int[][] memo = new int[nums.length][2 * sum + 1];
    for(int[] row : memo)
      Arrays.fill(row, -1);

    return helper(memo, sum, nums, S, 0, 0);
  }

  public int helper(int[][] memo, int sum, int[] nums, int S, int current, int index) {
    if(index >= nums.length) {
      if(current == S) return 1;
      return 0;
    }
    if(memo[index][current + sum] >= 0) return memo[index][current + sum];

    int result =
      helper(memo, nums, S, current - nums[index], index + 1) +
      helper(memo, nums, S, current + nums[index], index + 1);

    memo[index][current + sum] = result;

    return result;
  }

  // 2: dp method to above recursion, same concept: keep track of branching tree
  //    get the latest iteration of the tree and get S
  public int findTargetSumWays(int[] nums, int S) {
    int sum = 0;
    for(int num : nums)
      sum += num;

    if(S > sum || S < -sum) return 0;

    int[][] dp = new int[nums.length][2 * sum + 1];

    dp[0][-nums[0] + sum] = 1;
    dp[0][nums[0] + sum] += 1;
    for(int i = 1; i < nums.length; i++) {
      for(int j = 0; j < dp[i].length; j++) {
        if(dp[i - 1][j] > 0) {
          // add last iteration to current iteration
          // j = runningSum from last iteration
          dp[i][j - nums[i]] += dp[i - 1][j];
          dp[i][j + nums[i]] += dp[i - 1][j];
        }
      }
    }

    return dp[nums.length - 1][S + sum];
  }
}
