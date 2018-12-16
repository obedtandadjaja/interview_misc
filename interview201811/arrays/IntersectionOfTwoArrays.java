/*
  Difficulty: Easy

  Given two arrays, write a function to compute their intersection.

  Example 1:

  Input: nums1 = [1,2,2,1], nums2 = [2,2]
  Output: [2,2]
  Example 2:

  Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
  Output: [4,9]
  Note:

  Each element in the result should appear as many times as it shows in both arrays.
  The result can be in any order.
 */

class IntersectionOfTwoArrays {
  // time-complexity: O(2n)
  // space-complexity: O(2n)
  // fun-fact: this takes longer than the O(n log n) implementation below
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<Integer>();

    for(int i = 0; i < nums1.length; i++)
      map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

    for(int i = 0; i < nums2.length; i++) {
      int occurrence = map.getOrDefault(nums2[i], 0);
      if(occurrence > 0) {
        result.add(nums2[i]);
        map.put(nums2[i], occurrence - 1);
      }
    }

    int[] result_arr = new int[result.size()];
    for(int i = 0; i < result.size(); i++)
      result_arr[i] = result.get(i);

    return result_arr;
  }

  // time-complexity: O(n log n)
  // space-complexity: O(n)
  public int[] intersect(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    int index1 = 0;
    int index2 = 0;

    List<Integer> result = new ArrayList<>();

    while(index1 < nums1.length && index2 < nums2.length) {
      if(nums1[index1] == nums2[index2]) {
        result.add(nums1[index1]);
        index1++;
        index2++;
      } else {
        if(nums1[index1] > nums2[index2])
          while(index2 < nums2.length && nums1[index1] > nums2[index2]) index2++;
        else
          while(index1 < nums1.length && nums1[index1] < nums2[index2]) index1++;
      }
    }

    int[] result_arr = new int[result.size()];
    for(int i = 0; i < result.size(); i++)
      result_arr[i] = result.get(i);

    return result_arr;
  }
}
