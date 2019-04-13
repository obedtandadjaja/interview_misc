/*
  Difficulty: Medium

  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

  (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

  You are given a target value to search. If found in the array return true, otherwise return false.

  Example 1:

  Input: nums = [2,5,6,0,0,1,2], target = 0
  Output: true
  Example 2:

  Input: nums = [2,5,6,0,0,1,2], target = 3
  Output: false
  Follow up:

  This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
  Would this affect the run-time complexity? How and why?
 */

class Solution {
  public boolean search(int[] nums, int target) {
    int start = 0;
    for(int i = 1; i < nums.length; i++) {
      // why not try to find the target while finding the pivot
      if(nums[i] == target) return true;

      if(nums[i-1] > nums[i]) {
        start = i;
        break;
      }
    }

    int end = start + nums.length - 1;
    int mid = 0;
    int curr = 0;

    while(start <= end) {
      mid = (start + end) / 2;
      curr = mid % nums.length;

      if(nums[curr] < target) {
        start = mid + 1;
      } else if(nums[curr] > target) {
        end = mid - 1;
      } else {
        return true;
      }
    }

    return false;
  }

  // idea is to split the array into two, one section will be in order
  // check the inorder section of the array if b is within that then
  // go and find it
  public boolean search(List<Integer> a, int b) {
    int start = 0;
    int end = a.size() - 1;
    int mid = -1;

    while(start <= end) {
      mid = (start + end) / 2;

      if(a.get(mid) == b) {
        return true;
      } else if(a.get(start) < a.get(mid) || a.get(mid) > a.get(end)) { // conditions to choose section 1
        if(a.get(start) <= b && a.get(mid) > b)
          end = mid - 1;
        else
          start = mid + 1;
      } else if(a.get(mid) < a.get(end) || a.get(mid) < a.get(start)) { // conditions to choose section 2
        if(a.get(mid) < b && a.get(end) >= b)
          start = mid + 1;
        else
          end = mid - 1;
      } else {
        end--; // decrement end in case of duplicates i.e. [1,3,1,1]
      }
    }

    return false;
  }
}
