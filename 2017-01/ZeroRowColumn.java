import java.util.*;
public class ZeroRowColumn {

  public static void main(String[] args) {
    int[][] matrix = {
      {0,2,3,4,5,0},
      {0,1,2,3,4,5},
      {1,0,2,3,4,5},
      {1,2,3,0,0,5},
      {-2,-1,1,2,3,4},
      {1,2,3,4,5,6}
    };
    for(int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
    System.out.println();
    fillInZeroes(matrix);
    for(int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
  }

  public static void fillInZeroes(int[][] matrix) {
    boolean rowHasZero = false, colHasZero = false;
    // Iterate through first row and first row and check if they have zero
    for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      if(matrix[rowIndex][0] == 0) {
        colHasZero = true;
        break;
      }
    }
    for(int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
      if(matrix[0][colIndex] == 0) {
        rowHasZero = true;
        break;
      }
    }
    // use first row and first column as a cache/buffer to hold the positions of the zeroes
    // start with (1,1) to (n,n)
    for(int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
      for(int colIndex = 1; colIndex < matrix[0].length; colIndex++) {
        if(matrix[rowIndex][colIndex] == 0) {
          matrix[0][colIndex] = 0;
          matrix[rowIndex][0] = 0;
        }
      }
    }
    // check the cache and fill in the zeroes
    for(int rowIndex = matrix.length-1; rowIndex >= 1; rowIndex--) {
      if(matrix[rowIndex][0] == 0) {
        fillInColumnWith(matrix, rowIndex, 0);
      }
    }
    for(int colIndex = matrix[0].length-1; colIndex >= 1; colIndex--) {
      if(matrix[0][colIndex] == 0) {
        fillInRowWith(matrix, colIndex, 0);
      }
    }

    if(rowHasZero) fillInRowWith(matrix, 0, 0);
    if(colHasZero) fillInColumnWith(matrix, 0, 0);
  }

  public static void fillInColumnWith(int[][] matrix, int rowIndex, int filling) {
    for(int colIndex = 0; colIndex < matrix[rowIndex].length; colIndex++) {
      matrix[rowIndex][colIndex] = filling;
    }
  }

  public static void fillInRowWith(int[][] matrix, int colIndex, int filling) {
    for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
      matrix[rowIndex][colIndex] = filling;
    }
  }

}
