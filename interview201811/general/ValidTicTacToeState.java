/*
  Difficulty: Medium

  A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

  The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

  Here are the rules of Tic-Tac-Toe:

  Players take turns placing characters into empty squares (" ").
  The first player always places "X" characters, while the second player always places "O" characters.
  "X" and "O" characters are always placed into empty squares, never filled ones.
  The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
  The game also ends if all squares are non-empty.
  No more moves can be played if the game is over.
  Example 1:
  Input: board = ["O  ", "   ", "   "]
  Output: false
  Explanation: The first player always plays "X".

  Example 2:
  Input: board = ["XOX", " X ", "   "]
  Output: false
  Explanation: Players take turns making moves.

  Example 3:
  Input: board = ["XXX", "   ", "OOO"]
  Output: false

  Example 4:
  Input: board = ["XOX", "O O", "XOX"]
  Output: true
*/
class Solution {
  public boolean validTicTacToe(String[] board) {
    int countX = 0;
    int countO = 0;

    // count number of Xs and Os
    for(String row : board) {
      for(char c : row.toCharArray()) {
        if(c == 'X') countX++;
        else if(c == 'O') countO++;
      }
    }
    // O's cannot be more than X's
    if(countX - countO < 0) return false;
    // X's can only be more than O by 1
    else if(countX - countO > 1) return false;

    boolean winX = didWin(board, 'X');
    boolean winO = didWin(board, 'O');

    // they both can't win together
    if(winX && winO) return false;

    // if X wins then O count will be countX - 1
    if(winX && countX == countO) return false;

    // if O wins then X count will equal countO
    if(winO && countX > countO) return false;

    return true;
  }

  public boolean didWin(String[] board, char c) {
    for(int i = 0; i < board.length; i++) {
      if(winHorizontal(board, c, i)) return true;
      if(winVertical(board, c, i)) return true;
    }

    if(winDiagonal(board, c)) return true;

    return false;
  }

  public boolean winHorizontal(String[] board, char c, int row) {
    return board[row].charAt(0) == c &&
           board[row].charAt(1) == c &&
           board[row].charAt(2) == c;
  }

  public boolean winVertical(String[] board, char c, int col) {
    return board[0].charAt(col) == c &&
           board[1].charAt(col) == c &&
           board[2].charAt(col) == c;
  }

  public boolean winDiagonal(String[] board, char c) {
    return (board[0].charAt(0) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(2) == c) ||
           (board[0].charAt(2) == c &&
            board[1].charAt(1) == c &&
            board[2].charAt(0) == c);
  }
}
