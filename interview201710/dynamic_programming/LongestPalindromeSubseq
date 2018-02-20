/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
*/

class LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++) grid[i][i] = 1;
        return helper(grid, 0, n-1, s);
    }
    
    private static int helper(int[][] grid, int index1, int index2, String s){
        if(index1 > index2 || grid[index1][index2] != 0) return grid[index1][index2];
        
        if(s.charAt(index1) == s.charAt(index2)) 
            grid[index1][index2] = helper(grid, index1 + 1 , index2 - 1, s) + 2;
        else 
            grid[index1][index2] = Math.max(helper(grid, index1, index2 - 1, s), helper(grid, index1 + 1, index2, s));
        
        return grid[index1][index2];
    }
}
