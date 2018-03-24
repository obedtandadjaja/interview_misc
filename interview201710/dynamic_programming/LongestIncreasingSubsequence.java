/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. 
Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?
*/

class LongestIncreasingSubsequence {
    
    // BinarySearch approach
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
    
    // DP approach
    public int lengthOfLIS2(int[] nums) {
        int[][] dp = new int[nums.length+1][nums.length];
        return lengthofLIS(nums, -1, 0, dp);
    }

    public int lengthofLIS(int[] nums, int prev, int curpos, int[][] dp) {
        if (curpos == nums.length) return 0;
        
        if(dp[prev+1][curpos] > 0) return dp[prev+1][curpos];
        
        int taken = 0;
        if (prev < 0 || nums[curpos] > nums[prev]) {
            taken = 1 + lengthofLIS(nums, curpos, curpos + 1, dp);
        }
        int nottaken = lengthofLIS(nums, prev, curpos + 1, dp);
        
        dp[prev+1][curpos] = Math.max(taken, nottaken);
        return dp[prev+1][curpos];
    }
}
