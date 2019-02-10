/*
  Difficulty: Hard

  Given an array of non-negative integers, you are initially positioned at the first index of the array.

  Each element in the array represents your maximum jump length at that position.

  Your goal is to reach the last index in the minimum number of jumps.

  Example:

  Input: [2,3,1,1,4]
  Output: 2
  Explanation: The minimum number of jumps to reach the last index is 2.
  Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

class Solution {
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];

    dp[0] = 0;
    for(int i = 0; i < nums.length; i++) {
      for(int j = Math.min(nums[i], nums.length - i - 1); j > 0; j--) {
        if(dp[i + j] == 0)
          dp[i + j] = dp[i] + 1;
        else
          break;
      }
    }

    return dp[nums.length-1];
  }
}
