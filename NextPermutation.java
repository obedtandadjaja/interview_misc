import java.util.*;
public class NextPermutation {
  static int[] c = {1,2,3,4,5};
  public static void main(String[] args) {
    printPermutations();
    // System.out.println(Arrays.toString(nextPermutation()));
  }

  public static void printPermutations() {
    while(c != null){
      System.out.println(Arrays.toString(c));
      getPermutation();
    }
  }

  public static void getPermutation() {
    for (int a = c.length - 2; a >= 0; a--) {
      if (c[a] < c[a + 1])
        for (int b = c.length - 1; b >= 0; b--){
          if (c[b] > c[a]) {
            int t = c[a];
            c[a] = c[b];
            c[b] = t;
            for (++a, b = c.length - 1; a < b; ++a, --b) {
              t = c[a];
              c[a] = c[b];
              c[b] = t;
            }
            return;
          }
        }
    }
    c = null;
    return;
  }
}