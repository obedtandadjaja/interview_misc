/*
  Difficulty: Medium

  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

  Integers in each row are sorted from left to right.
  The first integer of each row is greater than the last integer of the previous row.
  Example 1:

  Input:
  matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
  ]
  target = 3
  Output: true
  Example 2:

  Input:
  matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
  ]
  target = 13
  Output: false
 */

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0) return false;

    int rows = matrix.length;
    int cols = matrix[0].length;

    // first binary search - find row
    int start = 0;
    int end = rows - 1;
    while(start <= end) {
      int mid = (start + end)/2;
      if(matrix[mid][0] == target) return true;
      else if(matrix[mid][0] > target) end = mid - 1;
      else start = mid + 1;
    }

    if(end < 0) return false;
    int row = end;

    // second binary search - find col
    start = 1;
    end = cols - 1;
    while(start <= end) {
      int mid = (start + end)/2;
      if(matrix[row][mid] == target) return true;
      else if(matrix[row][mid] > target) end = mid - 1;
      else start = mid + 1;
    }

    return false;
  }
}
