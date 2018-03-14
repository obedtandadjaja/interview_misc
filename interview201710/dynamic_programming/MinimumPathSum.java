/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all 
numbers along its path.

Note: You can only move either down or right at any point in time.

Example 1:
[[1,3,1],
 [1,5,1],
 [4,2,1]]
 
Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
*/

class Solution {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
            new int[] { 1,3,1 },
            new int[] { 1,5,1 },
            new int[] { 4,2,1 }
        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return findPath(grid, dp, 0, 0);
    }
    
    public static int findPath(int[][] grid, int[][] dp, int x, int y) {
        if(dp[x][y] > 0) {
            return dp[x][y];
        } else if(x == grid.length-1 && y == grid[0].length-1) {
            dp[x][y] = grid[x][y];
            return grid[x][y];
        } else {
            int right = Integer.MAX_VALUE;
            int down = Integer.MAX_VALUE;
            if(x < grid.length-1) down = findPath(grid, dp, x+1, y);
            if(y < grid[0].length-1) right = findPath(grid, dp, x, y+1);
            int result = grid[x][y] + Math.min(right, down);
            dp[x][y] = result;
            return result;
        }
    }
}
