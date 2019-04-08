/*
  Difficulty: Medium

  Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

  Example 1:

  Input: 2
  Output: [0,1,1]
  Example 2:

  Input: 5
  Output: [0,1,1,2,1,2]
 */

class Solution {
  public int[] countBits(int num) {
    int[] dp = new int[num + 1];
    dp[0] = 0;

    if(num > 0) dp[1] = 1;
    if(num > 1) dp[2] = 1;

    int lastPowerOf2 = 2;
    for(int i = 3; i <= num; i++) {
      if(isPowerOf2(i)) {
        dp[i] = 1;
        lastPowerOf2 = i;
      } else {
        dp[i] = dp[lastPowerOf2] + dp[i - lastPowerOf2];
      }
    }

    return dp;
  }

  public boolean isPowerOf2(int n) {
    return (n & (n - 1)) == 0;
  }
}
