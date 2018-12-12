/*
	Difficulty: Medium
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.

	A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	How many possible unique paths are there?


	Above is a 7 x 3 grid. How many possible unique paths are there?

	Note: m and n will be at most 100.

	Example 1:

	Input: m = 3, n = 2
	Output: 3
	Explanation:
	From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	1. Right -> Right -> Down
	2. Right -> Down -> Right
	3. Down -> Right -> Right
	Example 2:

	Input: m = 7, n = 3
	Output: 28
 */

class UniquePaths {
	// DP
  public int uniquePaths(int m, int n) {
    if(m == 1 || n == 1) return 1;

    int[][] grid = new int[m][n];

    for(int i = 1; i < m; i++) grid[i][0] = 1;
    for(int j = 1; j < n; j++) grid[0][j] = 1;

    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        grid[i][j] = grid[i-1][j] + grid[i][j-1];
      }
    }

    return grid[m-1][n-1];
  }

	// recursive
  public int uniquePaths2(int m, int n, int x, int y, int count) {
    if(x == m-1 && y == n-1) {
      System.out.println(path);
      return 1;
    }
    else if(x >= m || y >= n) return 0;

    return getPaths(m, n, x+1, y, count) + getPaths(m, n, x, y+1, count);
  }
}
