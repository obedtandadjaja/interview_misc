/*
  Difficulty: Medium

  Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

  Example 1:
  Input:nums = [1,1,1], k = 2
  Output: 2
  Note:
  The length of the array is in range [1, 20,000].
 */

class Solution {
  // 1 : brute force
  public int subarraySum(int[] nums, int k) {
    int count = 0;

    for(int start = 0; start < nums.length; start++) {
      int sum = 0;
      for(int end = start; end < nums.length; end++) {
        sum += nums[end];
        if(sum == k) count++;
      }
    }

    return count;
  }

  // 2 : cumulative sum, when sum[i] - sum[j] = k then sum(i to j) = k
  public int subarraySum(int[] nums, int k) {
    int count = 0;

    int[] sum = new int[nums.length + 1];
    sum[0] = 0;

    for(int i = 1; i <= nums.length; i++)
      sum[i] = sum[i - 1] + nums[i - 1];

    for(int start = 0; start < nums.length; start++) {
      for(int end = start + 1; end <= nums.length; end++) {
        if(sum[end] - sum[start] == k)
          count++;
      }
    }

    return count;
  }

  // 3: hashmap and cumulative sum
  //    idea: sum[i] - sum[j] = k, cumulative sum between 2 indices is k
  //          when their difference is k
  public int subarraySum(int[] nums, int k) {
    int count = 0;
    int sum = 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    for(int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if(map.containsKey(sum - k))
        count += map.get(sum - k);

      map.put(sum, map.getOrDefault(sum, 0) + 1);
    }

    return count;
  }
}
