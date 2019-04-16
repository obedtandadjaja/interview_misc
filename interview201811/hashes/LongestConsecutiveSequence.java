/*
  Difficulty: Medium

  Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

  Example:
  Given [100, 4, 200, 1, 3, 2],
  The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

  Your algorithm should run in O(n) complexity.
*/

public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int longestConsecutive(final List<Integer> A) {
    int longest = Integer.MIN_VALUE;

    Map<Integer, Integer> map = new HashMap();

    for(int a : A) {
      if(map.containsKey(a)) continue;

      int count = 1;
      int lower = map.getOrDefault(a - 1, 0);
      int higher = map.getOrDefault(a + 1, 0);
      int result = count + lower + higher;

      map.put(a, result);

      // update the ends
      map.put(a - lower, result);
      map.put(a + higher, result);

      longest = Math.max(longest, result);
    }

    return longest;
  }
}
