// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED import java.util.List; import java.util.Arrays;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
  int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot) {
    // WRITE YOUR CODE HERE
    if(numRows == 0 || numColumns == 0) return -1;

    int[][] grid = new int[numRows][numColumns];

    for(int i = 0; i < numRows; i++)
      Arrays.fill(grid[i], -1);

    if(lot.get(0).get(0) != 1) return -1;

    return DFS(lot, 0, 0, grid);
  }

  int DFS(List<List<Integer>> lot, int row, int col, int[][] grid) {
    if(row < 0 || row >= grid.length || col < 0|| col >= grid[0].length) return Integer.MAX_VALUE;

    // when we come across trench
    if(lot.get(row).get(col) == 0) return Integer.MAX_VALUE;

    // found obstacle
    if(lot.get(row).get(col) == 9) return 0;

    // when visited
    if(grid[row][col] == 0) return Integer.MAX_VALUE;

    // when we have traversed that path
    if(grid[row][col] > 0) return grid[row][col];

    // mark visited
    grid[row][col] = 0;

    int top = DFS(lot, row - 1, col, grid);
    int right = DFS(lot, row, col + 1, grid);
    int bottom = DFS(lot, row + 1, col, grid);
    int left = DFS(lot, row, col - 1, grid);

    int min = Math.min(Math.min(Math.min(top, right), bottom), left) + 1;

    if(min == Integer.MAX_VALUE) return Integer.MAX_VALUE;

    grid[row][col] = min + 1;

    return grid[row][col];
  }
// METHOD SIGNATURE ENDS
}
