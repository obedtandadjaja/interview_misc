/*
  Difficulty: Medium

  Given two sequences S, T, count number of unique ways in sequence S, to form a subsequence that is identical to the sequence T.

  Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none ) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
  Example :

  S = "rabbbit"
  T = "rabbit"
  Return 3. And the formations as follows:

  S1= "ra_bbit"
  S2= "rab_bit"
  S3="rabb_it"
  "_" marks the removed character.
*/

public class Solution {
  // 1: recursion with memoization
  public int numDistinct(String A, String B) {
    int[][] dp = new int[A.length()][B.length()];
    for(int[] arr : dp) Arrays.fill(arr, -1);

    return helper(A.toCharArray(), 0, B.toCharArray(), 0, dp);
  }

  public int helper(char[] A, int a, char[] B, int b, int[][] dp) {
    if(b >= B.length) return 1;
    if(a >= A.length) return 0;
    if(dp[a][b] >= 0) return dp[a][b];

    int count = 0;
    for(int i = a; i < A.length; i++) {
      if(A[i] == B[b]) {
        count += helper(A, i + 1, B, b + 1, dp);
      }
    }
    dp[a][b] = count;

    return dp[a][b];
  }

  // 2: DP
  public int numDistinct(String A, String B) {
    int[][] dp = new int[B.length() + 1][A.length() + 1];

    for(int i = 0; i < A.length() + 1; i++)
      dp[0][i] = 1;

    for(int i = 1; i < B.length() + 1; i++) {
      for(int j = 1; j < A.length() + 1; j++) {
        if(B.charAt(i - 1) == A.charAt(j - 1)) {
          // add sum of counts for that index + current for that index
          // only update if A[curr] == B[curr]
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else {
          // rollover prev value
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    return dp[B.length()][A.length()];
  }
}
