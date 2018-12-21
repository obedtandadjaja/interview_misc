/*
  Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

  Each row must contain the digits 1-9 without repetition.
  Each column must contain the digits 1-9 without repetition.
  Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

  A partially filled sudoku which is valid.

  The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

  Example 1:

  Input:
  [
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
  ]
  Output: true
  Example 2:

  Input:
  [
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
  ]
  Output: false
  Explanation: Same as Example 1, except with the 5 in the top left corner being 
  modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
  Note:

  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
  Only the filled cells need to be validated according to the mentioned rules.
  The given board contain only digits 1-9 and the character '.'.
  The given board size is always 9x9.
*/

class ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    int[] arr; // row
    int[] arr2; // column
    int[] arr3; // 3x3
    for(int i = 0; i < board.length; i++) {
      arr = new int[board.length];
      arr2 = new int[board.length];
      arr3 = new int[board.length];

      for(int j = 0; j < board.length; j++) {
        // check row
        if(board[i][j] - '1' >= 0) {
          if(arr[board[i][j] - '1'] > 0) return false;
          arr[board[i][j] - '1']++;
        }

        // check column
        if(board[j][i] - '1' >= 0) {
          if(arr2[board[j][i] - '1'] > 0) return false;
          arr2[board[j][i] - '1']++;
        }
      }

      // 3 x 3
      int row = (i / 3) * 3;
      int col = (i % 3) * 3;
      for(int j = row; j < row + 3; j++) {
        for(int k = col; k < col + 3; k++) {
          if(board[j][k] - '1' >= 0) {
            if(arr3[board[j][k] - '1'] > 0) return false;
            arr3[board[j][k] - '1']++;
          }
        }
      }
    }

    return true;
  }
}
