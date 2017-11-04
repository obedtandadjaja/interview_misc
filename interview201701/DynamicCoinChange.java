import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int amount = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(change(n, coins));
    }

    public static long change(int money, int[] coins) {
        long[] dp = new long[money + 1];
        dp[0] = 1;
        for(int i=0; i<coins.length; i++) {
            for(int j=coins[i]; j <= money; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[money];
    }
}
