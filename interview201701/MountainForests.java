import java.util.*;

public class MountainForests {

  public static int countForests(int[][] mountain) {
    int counter = 0;
    for(int row =  0; row < mountain.length; row++) {
      for(int col = 0; col < mountain[0].length; col++) {
        if(mountain[row][col] == 1) {
          DFS(mountain, row, col);
          counter++;
        }
      }
    }
    for(int i = 0; i < mountain.length; i++) {
      System.out.println(Arrays.toString(mountain[i]));
    }
    return counter;
  }

  public static void DFS(int[][] mountain, int row, int col) {
    if(row < 0 || col < 0 || row >= mountain.length || col >= mountain[0].length || mountain[row][col] == 0) return;
    mountain[row][col] = 0;
    DFS(mountain, row-1, col-1);
    DFS(mountain, row-1, col);
    DFS(mountain, row-1, col+1);
    DFS(mountain, row, col-1);
    DFS(mountain, row, col+1);
    DFS(mountain, row+1, col-1);
    DFS(mountain, row+1, col);
    DFS(mountain, row+1, col+1);
    mountain[row][col] = 1;
  }

  public static void main(String[] args) {
    int[][] mountain = {
      {1,0,0,1,1,1,0},
      {0,0,1,1,0,0,0},
      {1,0,0,0,0,1,0},
      {1,1,1,0,0,0,0},
      {1,1,0,0,0,1,1},
      {1,0,0,0,1,1,1},
      {1,1,0,0,0,1,1}
    };
    System.out.println(countForests(mountain));
  }
}
