/*
  Difficulty: Medium

  Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

  Example 1:

  Input:
  11110
  11010
  11000
  00000

  Output: 1
  Example 2:

  Input:
  11000
  11000
  00100
  00011

  Output: 3
 */

class Solution {
  public int numIslands(char[][] grid) {
    int counter = 0;
    for(int i = 0; i < grid.length; i++) {
      for(int j = 0; j < grid[i].length; j++) {
        if(grid[i][j] == '1') {
          counter++;
          DFS(grid, i, j);
        }
      }
    }

    return counter;
  }

  public void DFS(char[][] grid, int row, int col) {
    if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return;
    if(grid[row][col] == '0' || grid[row][col] == '2') return;

    grid[row][col] = '2';

    DFS(grid, row + 1, col);
    DFS(grid, row, col + 1);
    DFS(grid, row - 1, col);
    DFS(grid, row, col - 1);
  }
}
