/*
  Difficulty: Medium

  Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

  Example:

  Input: 3
  Output: 5
  Explanation:
  Given n = 3, there are a total of 5 unique BST's:

  1         3     3      2      1
  \       /     /      / \      \
  3     2     1      1   3      2
  /     /       \                 \
  2     1         2                 3
 */

class Solution {
  // 1: dp - idea is to choose a root and multiply the left and right nodes
  // e.g. when n = 3
  //      1. chose root = 1, with 2 right nodes = 2
  //      2. choose root = 2, with 1 left and 1 right node = 1
  //      3. choose root = 3, with 2 left nodes = 2
  //      total = 2 + 1 + 2 = 5
  public int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <= n; ++i) {
      for(int j = 1; j <= i; ++j) {
        dp[i] += dp[j - 1] * dp[i - j];
      }
    }

    return dp[n];
  }

  // 2: recursion with memoization, same idea but more explicit
  public int numTrees(int n) {
    if(n <= 1) return n;

    int[][] memo = new int[n + 1][n + 1];
    return helper(memo, 1, n);
  }

  public int helper(int[][] memo, int start, int end) {
    if(start > end) return 1;
    if(memo[start][end] > 0) return memo[start][end];

    int count = 0;
    for(int i = start; i <= end; i++) {
      int left = helper(memo, start, i - 1);
      int right = helper(memo, i + 1, end);

      count += left * right;
    }

    memo[start][end] = count;
    return count;
  }
}
