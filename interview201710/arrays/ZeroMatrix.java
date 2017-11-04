public class ZeroMatrix {
  public static void main(String[] args) {
    printMatrix(new int[][] {
      { 1,2,3,4 },
      { 5,0,7,8 },
      { 9,10,0,12},
      { 13,14,15,16}
    });
    System.out.println();
    printMatrix(zeroMatrix(new int[][] {
      { 1,2,3,4 },
      { 5,0,7,8 },
      { 9,10,0,12},
      { 13,14,15,16}
    }));
    System.out.println("-----------");
    printMatrix(new int[][] {
      { 0,2,3,4 },
      { 5,1,7,8 },
      { 9,10,1,12},
      { 13,14,15,0}
    });
    System.out.println();
    printMatrix(zeroMatrix(new int[][] {
      { 0,2,3,4 },
      { 5,1,7,8 },
      { 9,10,1,12},
      { 13,14,15,0}
    }));
  }

  public static void printMatrix(int[][] matrix) {
    for(int i = 0; i < matrix.length; i++) {
      System.out.print("[");
      for(int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + ", ");
      }
      System.out.println("]");
    }
  }

  public static int[][] zeroMatrix(int[][] matrix) {
    boolean zeroInFirstRow = false;
    boolean zeroInFirstCol = false;

    for(int i = 0; i < matrix.length; i++) {
      for(int j = 0; j < matrix[0].length; j++) {
        if(matrix[i][j] == 0) {
          zeroInFirstRow |= i == 0;
          zeroInFirstCol |= j == 0;
          matrix[i][0] = 0;
          matrix[0][j] = 0;
        }
      }
    }

    for(int i = 1; i < matrix.length; i++) if(matrix[i][0] == 0) zeroOutRow(matrix, i);
    for(int j = 1; j < matrix[0].length; j++) if(matrix[0][j] == 0) zeroOutCol(matrix, j);

    if(zeroInFirstRow) zeroOutRow(matrix, 0);
    if(zeroInFirstCol) zeroOutCol(matrix, 0);

    return matrix;
  }

  public static int[][] zeroOutRow(int[][] matrix, int row) {
    for(int j = 0; j < matrix[row].length; j++) matrix[row][j] = 0;
    return matrix;
  }

  public static int[][] zeroOutCol(int[][] matrix, int col) {
    for(int i = 0; i < matrix.length; i++) matrix[i][col] = 0;
    return matrix;
  }
}
