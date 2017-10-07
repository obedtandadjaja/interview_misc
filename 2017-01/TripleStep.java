import java.util.*;
public class TripleStep {
  public static HashMap<Integer, Integer> hash;

  public static void main(String[] args) {
    int n = 5;
    int[] memo = new int[n+1];
    Arrays.fill(memo, -1);
    hash = new HashMap<>();
    System.out.println(countWays(n, memo));
    System.out.println(countWays2(n));
    System.out.println(hash.toString());
  }
  public static int countWays(int n, int[] memo) {
    if(n < 0) return 0;
    else if(n == 0) return 1;
    else if(memo[n] > -1) return memo[n];
    else {
      memo[n] = countWays(n-1, memo)+countWays(n-2, memo)+countWays(n-3, memo);
      return memo[n];
    }
  }
}
