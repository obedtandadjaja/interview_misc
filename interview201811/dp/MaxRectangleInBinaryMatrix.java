/*
  Difficulty: Medium

  Given a 2D binary matrix filled with 0’s and 1’s, find the largest rectangle containing all ones and return its area.

  Bonus if you can solve it in O(n^2) or less.

  Example :

  A : [  1 1 1
  0 1 1
  1 0 0
  ]

  Output : 4

  As the max area rectangle is created by the 2x2 rectangle created by (0,1), (0,2), (1,1) and (1,2)
*/

public class Solution {
  public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
    if(A.size() == 0) return 0;

    int max = 0;
    int[][] horizontal = new int[A.size()][A.get(0).size()];

    // gather horizontal count
    for(int i = 0; i < A.size(); i++) {
      for(int j = 0; j < A.get(i).size(); j++) {
        if(A.get(i).get(j) == 0) continue;

        int left = j > 0 ? horizontal[i][j - 1] : 0;
        horizontal[i][j] = left + 1;
      }
    }

    // for every horizontal iterate, previous rows and keep track of
    // 1. how many rows until hit 0
    // 2. minimum columns (width)
    // compute rows * current min columns => max
    for(int i = 0; i < A.size(); i++) {
      for(int j = 0; j < A.get(i).size(); j++) {
        int row = i;
        int minCol = horizontal[i][j];

        while(row >= 0 && horizontal[row][j] > 0) {
          minCol = Math.min(minCol, horizontal[row][j]);
          max = Math.max(max, (i - row + 1) * minCol);
          row--;
        }
      }
    }

    return max;
  }
}
