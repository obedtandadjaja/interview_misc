/*

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1

Input: [3,0,1]
Output: 2
Example 2

Input: [9,6,4,2,3,5,7,0,1]
Output: 8

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

class MissingNumber {
    public int missingNumber(int[] nums) {
        int total = 0;
        int expected = 0;

        for(int i = 0; i < nums.length; i++) {
            total += nums[i];
            expected += i+1;
        }

        return expected - total;
    }

    // idea is to use xor to number and index
    // the missing number will leave the index xor
    // no couple to xor the number again
    public int missingNumber2(int[] nums) {
        int x = 0;

        for(int i = 0; i < nums.length; i++) {
            x ^= nums[i] ^ i;
        }

        return x ^ nums.length;
    }
}
