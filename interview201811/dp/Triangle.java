/*
  Difficulty: Medium

  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

  For example, given the following triangle

  [
  [2],
  [3,4],
  [6,5,7],
  [4,1,8,3]
  ]
  The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

  Note:

  Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle.size() == 0) return 0;

    int[][] dp = new int[triangle.size()][triangle.size()];

    for(int i = 0; i < triangle.get(dp.length - 1).size(); i++)
      dp[dp.length - 1][i] = triangle.get(dp.length - 1).get(i);

    for(int row = triangle.size() - 2; row >= 0; row--) {
      for(int col = 0; col < triangle.get(row).size(); col++) {
        dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1]) + triangle.get(row).get(col);
      }
    }

    return dp[0][0];
  }
}
