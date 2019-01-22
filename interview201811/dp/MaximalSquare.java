/*
  Difficulty: Medium

  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

  Example:

  Input: 

  1 0 1 0 0
  1 0 1 1 1
  1 1 1 1 1
  1 0 0 1 0

  Output: 4
 */

class Solution {
  public int maximalSquare(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;

    int max = matrix[0][0];

    // first row
    if(max == 0) {
      for(int i = 1; i < matrix[0].length; i++) {
        if(matrix[0][i] == 1) {
          max = matrix[0][i];
          break;
        }
      }
    }

    // first col
    if(max == 0) {
      for(int i = 1; i < matrix[0].length; i++) {
        if(matrix[i][0] == 1) {
          max = matrix[i][0];
          break;
        }
      }
    }

    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[0].length; j++) {
        if(matrix[i][j] == 1) {
          matrix[i][j] = Math.min(Math.min(matrix[i-1][j-1], matrix[i-1][j]), matrix[i][j-1]) + 1;
          max = Math.max(max, matrix[i][j]);
        }
      }
    }

    return max * max;
  }
}
