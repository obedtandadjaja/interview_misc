public class MakeChange {

  public static int makeChange(int n, int[] denoms) {
    int[][] map = new int[n + 1][denoms.length];
    return makeChange(n, denoms, 0, map);
  }

  public static int makeChange(int amount, int[] denoms, int index, int[][] map) {
    if (map[amount][index] > 0) { // retrieve value
      return map[amount][index];
    }
    if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
    int denomAmount = denoms[index];
    int ways = 0;
    for (int i = 0; i * denomAmount <= amount; i++) {
      // go to next denom, assuming i coins of denomAmount
      int amountRemaining = amount - i * denomAmount;
      ways += makeChange(amountRemaining, denoms, index + 1, map);
    }
    map[amount][index] = ways;
    return ways;
  }

  public static int makeChange2(int n, int index, int[][] memo, int[] coins) {
    if(n == 0) {
      return 1;
    }
    if(n < 0) return 0;
    if(index == 4) {
      return 0;
    }
    if(memo[n][index] > 0) {
      return memo[n][index];
    }
    for(int i = 0; i * coins[index] <= n; i++) {
      memo[n][index] += makeChange2(n-coins[index]*i, index+1, memo, coins);
    }
    return memo[n][index];
  }

  public static void main(String[] args) {
    int change = 100;
    int[] denoms = {25, 10, 5, 1};
    int ways = makeChange(change, denoms);
    System.out.println(ways);
    int[] denoms2 = {1, 5, 10, 25};
    int ways2 = makeChange2(change, 0, new int[change+1][denoms2.length], denoms2);
    System.out.println(ways2);
  }

}
