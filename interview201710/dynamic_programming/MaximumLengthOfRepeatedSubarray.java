/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

Note:
1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
*/

class MaximumLengthOfRepeatedSubarray {
    public static void main(String[] args) {
        int[] A = new int[] { 1,2,3,2,1 };
        int[] B = new int[] { 3,2,1,4,7 };
        System.out.println(findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int max = 0;
        int[][] dp = new int[A.length + 1][B.length + 1];
        
        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                dp[i][j] = A[i-1] == B[j-1] ? dp[i-1][j-1] + 1 : 0;
                max = Math.max(dp[i][j], max);
            }
        }
        
        return max;
    }
}
