/*
  Difficulty: Medium

  Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

  Note:

  Each of the array element will not exceed 100.
  The array size will not exceed 200.

  Example 1:

  Input: [1, 5, 11, 5]

  Output: true

  Explanation: The array can be partitioned as [1, 5, 5] and [11].

  Example 2:

  Input: [1, 2, 3, 5]

  Output: false

  Explanation: The array cannot be partitioned into equal sum subsets.
 */

class Solution {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for(int num : nums)
      sum += num;

    // sum need to be an even number because:
    // 1. odd + odd = even
    // 2. even + even = even
    if(sum % 2 != 0) return false;
    int targetSum = sum / 2;

    return findSum2(nums, targetSum);
  }

  // 1 : dp - O(MN) where M = targetSum and N = size of nums
  public boolean findSum(int[] nums, int targetSum) {
    // row = # of elements, col = targetSum
    boolean[][] memo = new boolean[nums.length + 1][targetSum + 1];

    // first col make all true
    for(int i = 0; i < memo.length; i++)
      memo[i][0] = true;

    for(int i = 1; i < memo.length; i++) {
      for(int j = 1; j < memo[i].length; j++) {
        memo[i][j] = memo[i-1][j]; // copy over to next row

        if(j >= nums[i-1]) {
          memo[i][j] |= memo[i-1][j - nums[i-1]]; // if current - previous = true
        }
      }
    }

    return memo[nums.length][targetSum];
  }

  // 2 : memoization + binarySearch O(N^2) worst case, O(N log N) avg case
  public boolean findSum2(int[] nums, int targetSum) {
    Arrays.sort(nums);

    boolean[][] memo = new boolean[nums.length][targetSum];

    return findSum2Helper(nums, memo, targetSum - nums[nums.length - 1], nums.length - 2);
  }

  public boolean findSum2Helper(int[] nums, boolean[][] memo, int targetSum, int index) {
    if(index < 0) {
      if(targetSum == 0) return true;
      return false;
    }
    if(targetSum < 0) return false;
    if(targetSum == 0 || memo[index][targetSum]) return true;

    // do binary search on the targetSum to immediately get the nextIndex
    // NOTE: if not found, binarySearch will return (-insertionIndex - 1)
    int nextIndex = Arrays.binarySearch(nums, targetSum);

    if(nextIndex > 0) {
      return true;
    } else {
      // do min on index - 1 just in case it tries to choose itself again
      nextIndex = Math.min(index - 1, Math.abs(nextIndex - 1));

      // iterate down
      for(; nextIndex >= 0; nextIndex--) {
        if(findSum2Helper(nums, memo, targetSum - nums[nextIndex], nextIndex - 1))
          return true;
      }
    }

    memo[index][targetSum] = true;
    return false;
  }
}
