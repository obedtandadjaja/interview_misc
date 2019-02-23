/*
  Difficulty: Medium

  Given a square array of integers A, we want the minimum sum of a falling path through A.

  A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

  Example 1:

  Input: [[1,2,3],[4,5,6],[7,8,9]]
  Output: 12
  Explanation:
  The possible falling paths are:
  [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
  [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
  [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
  The falling path with the smallest sum is [1,4,7], so the answer is 12.

  Note:

  1 <= A.length == A[0].length <= 100
  -100 <= A[i][j] <= 100
 */

class Solution {
  public int minFallingPathSum(int[][] A) {
    if(A.length == 0) return 0;

    int[][] dp = new int[A.length][A.length];

    for(int i = 0; i < A[0].length; i++)
      dp[0][i] = A[0][i];

    int min = Integer.MAX_VALUE;
    for(int row = 1; row < A.length; row++) {
      for(int col = 0; col < A[row].length; col++) {
        if(col == 0) {
          dp[row][col] = Math.min(dp[row - 1][col], dp[row - 1][col + 1]);
        } else if(col == A[row].length - 1) {
          dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]);
        } else {
          dp[row][col] = Math.min(Math.min(dp[row - 1][col - 1], dp[row - 1][col]), dp[row - 1][col + 1]);
        }
        dp[row][col] += + A[row][col];
      }
    }

    for(int i = 0; i < A[0].length; i++)
      min = Math.min(min, dp[A.length - 1][i]);

    return min;
  }
}
