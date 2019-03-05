/*
Find common subsequence in two Strings. The subsequence can be non-contiguous.

Example:
"BATD"
"ABACD"
=> "BAD"

*/

class LongestCommonSubsequence {

    public int getLCS(String s1, String s2) {
        int[][] dp = new int[s1.length][s2.length];
        Arrays.fill(dp, -1);
        return LCS(s1, s2, s1.length-1, s2.length-1, dp);
    }

    // recursive
    public int LCS(String s1, String s2, int index1, int index2, int[][] dp) {
        if(dp[index1][index2] != -1) return dp[index1][index2];
        else if(index1 < 0 || index2 < 0) return 0;

        if(s1.charAt(index1) == s2.charAt(index2)) {
            int length = LCS(s1, s2, index1-1, index2-1, dp);
            dp[index1][index2] = length;
            return length;
        } else {
            int length = Math.max(LCS(s1, s2, index1-1, index2, dp), LCS(s1, s2, index1, index2-1, dp);
            dp[index1][index2] = length;
            return length;
        }
    }

    // iterative - bottom up
    public int iterativeLCS(String s1, String s2) {
        int[][] dp = new int[s1.length+1][s2.length+1];
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[i].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i][j-1]);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length][s2.length];
    }

}
