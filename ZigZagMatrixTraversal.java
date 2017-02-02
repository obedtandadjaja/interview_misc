import java.util.*;
public class ZigZagMatrixTraversal {

  public static void main(String[] args) {
    traverse(new int[][] {
      {1,2,3,4,5,6},
      {4,5,6,7,8,9},
      {7,8,9,9,9,9}
    }, 0, 0);
  }

  public static void traverse(int[][] matrix, int row, int col) {
    int currRow = row;
    int currCol = col;
    do {
      matrix[currRow][currCol] = -1;
      printMatrix(matrix);
      currRow++;
      currCol--;
    } while(!isOutOfBounds(matrix, currRow, currCol));
    if((row != matrix.length-1 || col != matrix[0].length-1)) {
      if(col == matrix[0].length-1) row++;
      else col++;
      if(!isOutOfBounds(matrix, row, col)) traverse(matrix, row, col);
    }
  }

  public static void printMatrix(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      System.out.println(Arrays.toString(matrix[i]));
    }
    System.out.println();
  }

  public static boolean isOutOfBounds(int[][] matrix, int row, int col) {
    return matrix == null || row < 0 || col < 0 || row == matrix.length || col == matrix[0].length;
  }

}
