public class ZeroMatrix {
  public static void main(String[] args) {
    int[][] matrix = {{1,2,3}, {0,2,2}, {1,2,3}};
    setZeros(matrix);
    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++)
        System.out.print(matrix[i][j]);
      System.out.println();
    }
  }

  public static void setZeros(int[][] matrix) {
    boolean rowHasZero = false;
    boolean colHasZero = false;
    for(int j = 0; j < matrix[0].length; j++) {
      if(matrix[0][j] == 0) {
        rowHasZero = true;
        break;
      }
    }
    for(int i = 0; i < matrix[0].length; i++) {
      if(matrix[0][i] == 0) {
        colHasZero = true;
        break;
      }
    }
    for(int i = 1; i < matrix.length; i++) {
      for(int j = 1; j < matrix[0].length; j++) {
        if(matrix[i][j] == 0) {
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }
    for(int i = 1; i < matrix.length; i++) {
      if(matrix[i][0] == 0) {
        nullifyRow(matrix, i);
      }
    }
    for(int i = 1; i < matrix[0].length; i++) {
      if(matrix[0][i] == 0) {
        nullifyCol(matrix, i);
      }
    }
    if(rowHasZero) nullifyRow(matrix, 0);
    if(colHasZero) nullifyCol(matrix, 0);
  }

  public static void nullifyCol(int[][] matrix, int index) {
    for(int i = 0; i < matrix.length; i++) {
      matrix[i][index] = 0;
    }
  }

  public static void nullifyRow(int[][] matrix, int index) {
    for(int i = 0; i < matrix[0].length; i++) {
      matrix[index][i] = 0;
    }
  }
}
