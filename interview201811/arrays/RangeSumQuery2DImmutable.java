/*
  Difficulty: Medium

  Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

  Range Sum Query 2D
  The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

  Example:
  Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
  ]

  sumRegion(2, 1, 4, 3) -> 8
  sumRegion(1, 1, 2, 2) -> 11
  sumRegion(1, 2, 2, 4) -> 12
  Note:
  You may assume that the matrix does not change.
  There are many calls to sumRegion function.
  You may assume that row1 ≤ row2 and col1 ≤ col2.
 */

class NumMatrix {
  int[][] matrix;
  int[][] cache;

  public NumMatrix(int[][] matrix) {
    this.matrix = matrix;

    if(matrix.length > 0) {
      this.cache = new int[matrix.length + 1][matrix[0].length + 1];
      for(int i = 0; i < matrix.length; i++) {
        for(int j = 0; j < matrix[i].length; j++) {
          this.cache[i + 1][j + 1] =
            this.cache[i][j + 1] +
            this.cache[i + 1][j] -
            this.cache[i][j] +
            this.matrix[i][j];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if(row1 < 0 || row1 >= this.matrix.length || row2 < 0 || row2 >= this.matrix.length) return -1;
    if(col1 < 0 || col1 >= this.matrix[0].length || col2 < 0 || col2 >= this.matrix[0].length) return -1;

    return
      this.cache[row2 + 1][col2 + 1] +
      this.cache[row1][col1] -
      this.cache[row2 + 1][col1] -
      this.cache[row1][col2 + 1];
  }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
