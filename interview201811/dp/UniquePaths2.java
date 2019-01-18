/*
  Difficulty: Medium

  A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

  The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

  Now consider if some obstacles are added to the grids. How many unique paths would there be?



  An obstacle and empty space is marked as 1 and 0 respectively in the grid.

  Note: m and n will be at most 100.

  Example 1:

  Input:
  [
  [0,0,0],
  [0,1,0],
  [0,0,0]
  ]
  Output: 2
  Explanation:
  There is one obstacle in the middle of the 3x3 grid above.
  There are two ways to reach the bottom-right corner:
  1. Right -> Right -> Down -> Down
  2. Down -> Down -> Right -> Right
 */

class Solution {
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if(obstacleGrid[0][0] == 1 ||
       obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;

    obstacleGrid[0][0] = -1;

    // first row
    for(int i = 1; i < obstacleGrid[0].length; i++)
      if(obstacleGrid[0][i] < 1)
        obstacleGrid[0][i] = obstacleGrid[0][i-1];

    // first col
    for(int i = 1; i < obstacleGrid.length; i++)
      if(obstacleGrid[i][0] < 1)
        obstacleGrid[i][0] = obstacleGrid[i-1][0];

    for(int i = 1; i < obstacleGrid.length; i++) {
      for(int j = 1; j < obstacleGrid[0].length; j++) {
        if(obstacleGrid[i][j] == 1) continue;

        if(i > 0 && obstacleGrid[i-1][j] < 1)
          obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i-1][j];
        if(j > 0 && obstacleGrid[i][j-1] < 1)
          obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i][j-1];
      }
    }

    return Math.abs(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]);
  }
}
