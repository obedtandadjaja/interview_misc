/*
 Difficulty: Medium

 Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

  Triangle number: a + b > c || b + c > a || a + c > b

  Example 1:
  Input: [2,2,3,4]
  Output: 3
  Explanation:
  Valid combinations are:
  2,3,4 (using the first 2)
  2,3,4 (using the second 2)
  2,2,3
*/

class Solution {
  // idea is generating two sums
  // iterate down the array and try to find 2 sums that would be greater than target
  // use 2 pointers and when left + right > target, then n where left < n < right
  // would also be greater than target so we add count += right - left
  public int triangleNumber(int[] nums) {
    int count = 0;

    Arrays.sort(nums);

    for(int i = nums.length - 1; i >= 2; i--) {
      int target = nums[i];
      int left = 0;
      int right = i - 1;

      while(left < right) {
        int sum = nums[left] + nums[right];

        if(sum > target) {
          count += right - left;
          right--;
        } else {
          left++;
        }
      }
    }

    return count;
  }
}
