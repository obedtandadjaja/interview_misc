import java.util.*;
public class RandomMatrix {

  static int[][] matrix;

  public static void main(String[] args) {
    matrix = new int[5][5];
    randomize(0,0);
    for(int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public static void randomize(int row, int col) {
    if(row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || matrix[row][col] != 0) {
      return;
    }
    Random r = new Random();
    int i;
    do {
      i = r.nextInt(matrix.length)+1;
      matrix[row][col] = i;
    } while(!isValid(row, col, i));
    randomize(row+1, col);
    randomize(row, col+1);
    randomize(row, col);
  }

  public static boolean isValid(int row, int col, int n) {
    int counter = 0;
    for(int i = 0; i < matrix.length; i++) {
      if(matrix[i][col] == n) {
        if(counter == 2) return false;
        counter++;
      }
    }
    counter = 0;
    for(int i = 0; i < matrix.length; i++) {
      if(matrix[row][i] == n) {
        if(counter == 2) return false;
        counter++;
      }
    }
    return true;
  }

}
