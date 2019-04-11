/*
  Difficulty: Hard

  Given an unsorted integer array, find the smallest missing positive integer.

  Example 1:
  Input: [1,2,0]
  Output: 3

  Example 2:
  Input: [3,4,-1,1]
  Output: 2

  Example 3:
  Input: [7,8,9,11,12]
  Output: 1

  Note:
  Your algorithm should run in O(n) time and uses constant extra space.
*/

class Solution {
  // 1: use BitSet to find the next clear bit
  public int firstMissingPositive(int[] nums) {
    BitSet set = new BitSet();
    for(int num : nums) {
      if(num <= 0) continue;
      set.flip(num);
    }

    return set.nextClearBit(1);
  }

  // 2: use binarySearch and visited sorted list to get to the next missing number
  public int firstMissingPositive(int[] nums) {
    List<Integer> visited = new ArrayList();

    int missing = 1;
    for(int num : nums) {
      if(num <= 0) continue; // we don't care about finding negatives or zeroes

      if(num == missing) {
        missing++;

        // just in case next missing have been found, increment
        while(Collections.binarySearch(visited, missing) >= 0)
          missing++;
      } else {
        // add it to the visited collection
        int insertionIndex = Collections.binarySearch(visited, num);
        if(insertionIndex < 0) {
          insertionIndex = insertionIndex * -1 - 1;
          visited.add(insertionIndex, num);
        }
      }
    }

    return missing;
  }

  // 3: idea is the positive number should exist in the array's index
  //    [1,3,4] -> the missing number 2 is in between 1 - (n+1)
  //    flip positive to negative when we have found the number
  public int firstMissingPositive(int[] nums) {
    // go through array and change zeroes and negatives to (n + 1)
    // since -(n+1) - 1 will always be bigger than the array
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] <= 0) nums[i] = nums.length + 1;
    }

    // second iteration - flip num[value] to negative if not already
    for(int i = 0; i < nums.length; i++) {
      // get the newIndex, need to do abs here since some may have already been visited
      int newIndex = Math.abs(nums[i]) - 1;

      // if newIndex is in between the range
      if(newIndex >= 0 && newIndex < nums.length) {
        // only change it to negative if not already
        if(nums[newIndex] > 0) {
          nums[newIndex] *= -1;
        }
      }
    }

    // positive number = unvisited
    int missing = 0;
    while(missing < nums.length && nums[missing] < 0) {
      missing++;
    }

    // increment here since we are storing 1 in index 0
    return missing + 1;
  }
}
