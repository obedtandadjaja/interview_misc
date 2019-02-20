/*
  Difficulty: Medium

  In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  These characters divide the square into contiguous regions.

  (Note that backslash characters are escaped, so a \ is represented as "\\".)

  Return the number of regions.
 */

class Solution {
  public int regionsBySlashes(String[] grid) {
    int size = grid.length;
    int[] subsets = new int[4 * size * size];
    for(int i = 0; i < subsets.length; i++) subsets[i] = i;

    for(int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++) {
        int root = (i * size + j) * 4;
        char c = grid[i].charAt(j);

        if(c == '\\') {
          union(subsets, root + 0, root + 1);
          union(subsets, root + 2, root + 3);
        } else if(c == '/') {
          union(subsets, root + 0, root + 3);
          union(subsets, root + 1, root + 2);
        } else {
          union(subsets, root + 0, root + 1);
          union(subsets, root + 1, root + 2);
          union(subsets, root + 2, root + 3);
        }

        // connect up
        if(i - 1 >= 0)
          union(subsets, ((i - 1) * size + j) * 4 + 2, root + 0);

        // connect down
        if(i + 1 < grid.length)
          union(subsets, ((i + 1) * size + j) * 4 + 0, root + 2);

        // connect left
        if(j - 1 >= 0)
          union(subsets, (i * size + j - 1) * 4 + 1, root + 3);

        // connect right
        if(j + 1 < grid.length)
          union(subsets, (i * size + j + 1) * 4 + 3, root + 1);
      }
    }

    System.out.println(Arrays.toString(subsets));

    int counter = 0;
    for(int i = 0; i < subsets.length; i++)
      if(subsets[i] == i)
        counter++;

    return counter;
  }

  public int find(int[] subsets, int x) {
    if(subsets[x] != x) subsets[x] = find(subsets, subsets[x]);
    return subsets[x];
  }

  public void union(int[] subsets, int x, int y) {
    subsets[find(subsets, x)] = find(subsets, y);
  }
}
