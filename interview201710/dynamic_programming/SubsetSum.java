/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.

Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
*/

class SubsetSum {
	public static void main (String[] args) {
	    int[] nums = new int[] { 3, 34, 4, 12, 5, 2 };
	    int sum = 9;
	    
	    boolean[][] dp = new boolean[sum+1][nums.length+1];
	    
	    for(int i = 0; i < dp[0].length; i++) dp[0][i] = true;
	    
	    for(int i = 1; i < dp.length; i++) { // sum
	        for(int j = 1; j < dp[0].length; j++) { // num
	            dp[i][j] = dp[i][j-1];
	            if(i >= nums[j-1]) {
	                dp[i][j] = dp[i][j] || dp[i - nums[j-1]][j-1];
	            }
	        }
	    }
	    
	    System.out.println(dp[sum][nums.length]);
	}
}
