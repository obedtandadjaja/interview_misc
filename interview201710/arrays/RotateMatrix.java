public class RotateMatrix {
  public static void main(String[] args) {
    printMatrix(new int[][] {
      { 1,2,3,4 },
      { 5,6,7,8 },
      { 9,10,11,12},
      { 13,14,15,16}
    });
    System.out.println();
    printMatrix(rotateMatrix(new int[][] {
      { 1,2,3,4 },
      { 5,6,7,8 },
      { 9,10,11,12},
      { 13,14,15,16}
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

  public static int[][] rotateMatrix(int[][] matrix) {
    for(int layer = 0; layer < matrix.length/2; layer++) {
      for(int i = layer; i < matrix.length-1-layer; i++) {
        int top = matrix[layer][i];
        matrix[layer][i] = matrix[matrix.length-1-i][layer];
        matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
        matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
        matrix[i][matrix.length-1-layer] = top;
      }
    }
    return matrix;
  }
}
