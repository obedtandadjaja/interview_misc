/*
  Difficulty: Medium

  Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
  Find all unique triplets in the array which gives the sum of zero.

  Note:

  Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
  The solution set must not contain duplicate triplets. For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
  (-1, 0, 1)
  (-1, -1, 2)
*/

public class Solution {
  public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
    ArrayList<ArrayList<Integer>> result = new ArrayList();
    HashSet<ArrayList<Integer>> set = new HashSet();

    if(A.size() <= 2) return result;

    Collections.sort(A);

    // loop through the smallest index and foxus on trying to get the other 2 values
    for(int i = 0; i < A.size() - 2; i++) {
      int left = i + 1;
      int right = A.size() - 1;
      int target = 0 - A.get(i);

      // set two pointers from leftmost and rightmost
      while(left < right && right < A.size()) {
        int curr = A.get(left) + A.get(right);

        if(curr == target) {
          ArrayList<Integer> currList = new ArrayList(Arrays.asList(A.get(i), A.get(left), A.get(right)));
          set.add(currList);

          left++;
          right--;
        }
        else if(curr < target) // if less than target then increase the lower end
          left++;
        else // if more than target then decrease the higher end
          right--;
      }
    }

    result.addAll(set);

    return result;
  }
}
