import java.util.*;
public class TicTacToe {

  static int[][] grid = new int[3][3];
  static int win = 0;
  static int count = 0;
  static int turn = 2;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while(win == 0){
      turn = (turn == 2 ? 1 : 2);
      int row = -1;
      int col = -1;
      do {
      System.out.println("Player "+turn+" turn");
      System.out.print("row: ");
      row = Integer.parseInt(sc.nextLine());
      System.out.print("col: ");
      col = Integer.parseInt(sc.nextLine());
      } while(!play(turn, row, col));
      print();
      if(checkWin()) win = 1;
    }
    if(win == 1) System.out.println("Player "+turn+" wins!");
    if(win == 2) System.out.println("It's a draw!");
  }

  public static boolean play(int turn, int row, int col) {
    if(grid[row][col] == 0) {
      grid[row][col] = turn;
      count++;
    } else {
      System.out.println("Invalid input");
      return false;
    }
    return true;
  }

  public static boolean checkWin() {
    return checkRow() || checkCol() || checkDiag();
  }

  public static boolean checkRow() {
    for(int i = 0; i < 3; i++) {
      boolean b = true;
      for(int j = 0; j < 3; j++) {
        if(grid[i][j] != turn)
          b = false;
      }
      if(b) return true;
    }
    return false;
  }

  public static boolean checkCol() {
    for(int i = 0; i < 3; i++) {
      boolean b = true;
      for(int j = 0; j < 3; j++) {
        if(grid[j][i] != turn)
          b = false;
      }
      if(b) return true;
    }
    return false;
  }

  public static boolean checkDiag() {
    boolean b = true;
    for(int i = 0; i < 3; i++) {
      if(grid[i][i] != turn)
        b = false;
    }
    if(b) return true;
    b = true;
    for(int i = 0; i < 3; i++) {
      if(grid[2-i][i] != turn)
        b = false;
    }
    return b;
  }

  public static void print() {
    for(int i = 0; i < 3; i++)
    {
      System.out.print("[");
      for(int j = 0; j < 3; j++) {
        if(grid[i][j] == 0) System.out.print("-, ");
        else System.out.print(grid[i][j] == 1 ? "X, " : "O, ");
      }
      System.out.print("]\n");
    }
  }
}