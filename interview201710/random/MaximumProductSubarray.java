/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */

import java.lang.Math;

class MaxProductSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] { 2,3,-2,4 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int result1 = nums[i] * max;
            int result2 = nums[i] * min;
            max = Math.max(Math.max(nums[i], result1), result2);
            min = Math.min(Math.min(nums[i], result1), result2);
            if(max > result) result = max;
        }
        return result;
    }
}
