class Solution {
  public int maximalSquare(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;

    int max = matrix[0][0];
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
