/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

// [1,2,3,2,3] => 1
//
// 0 0 0 0 1 => 1
// 0 0 0 1 0 => 2 ^
// 0 0 0 1 1
// 0 0 0 1 1 => 3 ^
// 0 0 0 0 0
// 0 0 0 1 0 => 2 ^
// 0 0 0 1 0
// 0 0 0 1 1 => 3 ^
// 0 0 0 0 1

class SingleNumber {

    public int singleNumber(int[] nums) {

        for(int i = 1; i < nums.length; i++)
            nums[i] ^= nums[i-1];

        return nums[nums.length-1];

    }
}
