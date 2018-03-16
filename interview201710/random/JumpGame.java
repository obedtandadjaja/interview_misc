/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.
A = [3,2,1,0,4], return false.
 */

import java.lang.Math;

class JumpGame {
    public static void main(String[] args) {
      int[] nums = new int[] { 2,3,1,1,4 };
      System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int maxLocation = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxLocation) return false;
            maxLocation = Math.max(maxLocation, i + nums[i]);
        }
        return true;
    }
}
