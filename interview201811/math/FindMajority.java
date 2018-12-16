/*
  Difficulty: Easy

  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

  You may assume that the array is non-empty and the majority element always exist in the array.

  Example 1:

  Input: [3,2,3]
  Output: 3
  Example 2:

  Input: [2,2,1,1,1,2,2]
  Output: 2
 */

class FindMajority {
  // sorting and get the middle
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
  }

  // Set a candidate and increment if candidate appears again
  // if not then decrement.
  // Because majority will always be +1, then the count will be > 0
  public int majorityElement2(int[] nums) {
    int count = 0;
    Integer candidate = null;

    for (int num : nums) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    return candidate;
  }
}
