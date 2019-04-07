/*
  Difficulty: Medium

  According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

  Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

  Any live cell with fewer than two live neighbors dies, as if caused by under-population.
  Any live cell with two or three live neighbors lives on to the next generation.
  Any live cell with more than three live neighbors dies, as if by over-population..
  Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
  Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

  Example:

  Input:
  [
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
  ]
  Output:
  [
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
  ]
  Follow up:

  Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
  In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

class Solution {
  public void gameOfLife(int[][] board) {
    for(int i = 0; i < board.length; i++)
      for(int j = 0; j < board[i].length; j++)
        board[i][j] = helper(board, i, j);

    for(int i = 0; i < board.length; i++)
      for(int j = 0; j < board[i].length; j++)
        board[i][j] %= 2;
  }

  public int helper(int[][] board, int row, int col) {
    int liveNeighbors = 0;

    if(getNeighbor(board, row - 1, col - 1) == 1) liveNeighbors++;
    if(getNeighbor(board, row - 1, col) == 1) liveNeighbors++;
    if(getNeighbor(board, row - 1, col + 1) == 1) liveNeighbors++;
    if(getNeighbor(board, row, col - 1) == 1) liveNeighbors++;
    if(getNeighbor(board, row, col + 1) == 1) liveNeighbors++;
    if(getNeighbor(board, row + 1, col - 1) == 1) liveNeighbors++;
    if(getNeighbor(board, row + 1, col) == 1) liveNeighbors++;
    if(getNeighbor(board, row + 1, col + 1) == 1) liveNeighbors++;

    if(liveNeighbors < 2 && board[row][col] == 1) { // dead if less than 2 neighbors
      return 2;
    } else if(liveNeighbors == 3 && board[row][col] == 0) { // live if exactly 3 neighbors
      return 3;
    } else if(liveNeighbors > 3 && board[row][col] == 1) { // dead if more than 3 neighbors
      return 2;
    } else { // do nothing
      return board[row][col];
    }
  }

  // 2 = used to live, now dead
  // 3 = used to be dead, now live
  // this function needs to return the former state so that the calculation is based on
  // former state
  public int getNeighbor(int[][] board, int row, int col) {
    if(row < 0 || row >= board.length || col < 0 || col >= board[row].length)
      return 0;

    if(board[row][col] < 2) return board[row][col];
    else return board[row][col] == 2 ? 1 : 0;
  }
}
