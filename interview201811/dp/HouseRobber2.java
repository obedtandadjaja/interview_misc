/*
  Difficulty: Medium

  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

  Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

  Example 1:

  Input: [2,3,2]
  Output: 3
  Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
  because they are adjacent houses.
  Example 2:

  Input: [1,2,3,1]
  Output: 4
  Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  Total amount you can rob = 1 + 3 = 4.
 */

class Solution {
  public int rob(int[] nums) {
    if(nums.length == 0) return 0;
    if(nums.length == 1) return nums[0];
    if(nums.length == 2) return nums[0] < nums[1] ? nums[1] : nums[0];

    int length = nums.length;
    int[][] dp = new int[2][length];

    // from 0 to length-1
    dp[0][0] = nums[0];
    dp[0][1] = Math.max(nums[0], nums[1]);

    for(int i = 2; i < length - 1; i++) {
      dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + nums[i]);
    }

    // from 1 to length
    dp[1][1] = nums[1];
    dp[1][2] = Math.max(nums[1], nums[2]);

    for(int i = 3; i < length; i++) {
      dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + nums[i]);
    }

    return Math.max(dp[0][length-2], dp[1][length-1]);
  }
}
