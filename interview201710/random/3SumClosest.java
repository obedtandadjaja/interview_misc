/*
Given an array S of n integers, find three integers in S such that the sum is closest to a 
given number, target. Return the sum of the three integers. You may assume that each input 
would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

import java.util.*;
import java.lang.Math;

class 3SumClosest {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 2, 1, -4 };
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minSum = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int start = i + 1; 
            int end = nums.length - 1;
            
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target) start++;
                else if(sum > target) end--;
                else {
                    return target;
                }
                
                if(min > Math.abs(target - sum)) {
                    min = Math.abs(target - sum);
                    minSum = sum;
                }
            }
        }
        
        return minSum;
    }
}
