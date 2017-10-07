import java.util.*;

public class TomJerry {

  static int minMoves = Integer.MAX_VALUE;
  static int[][] orimaze = {
      {0,1,2},
      {0,1,0},
      {2,0,0}
    };

  public static void main(String[] args) {
    int x = 0;
    int y = 0;
    System.out.println(getMinMoves(orimaze.clone(), x, y));
  }

  public static int getMinMoves(int[][] maze, int x, int y) {
    // System.out.println(cheesePositions(maze).toString());
    traverse(maze, x, y, 0, 0, cheesePositions(maze), 0, new int[maze.length][maze[0].length]);
    return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
  }

  public static void traverse(int[][] maze, int x, int y, int row, int col, HashSet<String> cheese, int moves, int[][] sol) {
    if((row >= 0 && row < maze.length) && (col >= 0 && col < maze[0].length) && maze[row][col] != 1 && sol[row][col] != 3 && moves < minMoves) {
      // System.out.println(row+" "+col+" "+moves);
      // System.out.println(cheese.size());
      if(maze[row][col] == 2) {
        cheese.remove(row+" "+col);
        if(cheese.isEmpty()) {
          printMaze(sol);
          traverseToJerry(maze, x, y, row, col, moves, new int[maze.length][maze[0].length]);
          cheese.add(row+" "+col);
          return;
        }
      }
      sol[row][col] = 3;
      printMaze(sol);
      traverse(maze, x, y, row+1, col, cheese, moves+1, sol);
      traverse(maze, x, y, row, col+1, cheese, moves+1, sol);
      traverse(maze, x, y, row-1, col, cheese, moves+1, sol);
      traverse(maze, x, y, row, col-1, cheese, moves+1, sol);
    }
  }

  public static void traverseToJerry(int[][] maze, int x, int y, int row, int col, int moves, int[][] sol) {
    if((row >= 0 && row < maze.length) && (col >= 0 && col < maze[0].length) && maze[row][col] != 1 && sol[row][col] != 4 && moves < minMoves) {
      // System.out.println(row+" "+col+" "+moves);
      if(row == y && col == x) {
        minMoves = Math.min(minMoves, moves);
        return;
      }
      sol[row][col] = 4;
      // printMaze(sol);
      traverseToJerry(maze.clone(), x, y, row+1, col, moves+1, sol);
      traverseToJerry(maze.clone(), x, y, row, col+1, moves+1, sol);
      traverseToJerry(maze.clone(), x, y, row-1, col, moves+1, sol);
      traverseToJerry(maze.clone(), x, y, row, col-1, moves+1, sol);
    }
  }

  public static void printMaze(int[][] maze) {
    for(int i = 0; i < maze.length; i++) {
      System.out.println(Arrays.toString(maze[i]));
    }
  }

  public static HashSet<String> cheesePositions(int[][] maze) {
    HashSet<String> cheese = new HashSet<>();
    for(int i = 0; i < maze.length; i++) {
      for(int j = 0; j < maze[i].length; j++) {
        if(maze[i][j] == 2) {
          cheese.add(i+" "+j);
        }
      }
    }
    return cheese;
  }

}
