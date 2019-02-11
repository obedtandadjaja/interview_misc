/*
  Difficulty: Medium

  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

  (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

  You are given a target value to search. If found in the array return its index, otherwise return -1.

  You may assume no duplicate exists in the array.

  Your algorithm's runtime complexity must be in the order of O(log n).

  Example 1:

  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4
  Example 2:

  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1
 */

class Solution {
  public int search(int[] nums, int target) {
    int starting_index = 0;
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] < nums[i-1]) {
        starting_index = i;
        break;
      }
    }

    int start = 0;
    int end = nums.length - 1;
    int middle = 0;
    int curr = 0;

    while(start <= end) {
      middle = (start + end) / 2;
      curr = (middle + starting_index) % nums.length;

      if(nums[curr] < target) {
        start = middle + 1;
      } else if(nums[curr] > target) {
        end = middle -1;
      } else {
        return curr;
      }
    }

    return -1;
  }
}
