/*
  Difficulty: Medium

  Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

  Example:

  Input:  [1,2,3,4]
  Output: [24,12,8,6]
  Note: Please solve it without division and in O(n).

  Follow up:
  Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[][] cache = new int[2][nums.length];

    cache[0][0] = nums[0];
    for(int i = 1; i < nums.length; i++)
      cache[0][i] = cache[0][i - 1] * nums[i];

    cache[1][nums.length - 1] = nums[nums.length - 1];
    for(int i = nums.length - 2; i >= 0; i--)
      cache[1][i] = cache[1][i + 1] * nums[i];

    for(int i = 0; i < nums.length; i++) {
      int left = i - 1 < 0 ? 1 : cache[0][i - 1];
      int right = i + 1 >= nums.length ? 1 : cache[1][i + 1];

      nums[i] = left * right;
    }

    return nums;
  }
}
