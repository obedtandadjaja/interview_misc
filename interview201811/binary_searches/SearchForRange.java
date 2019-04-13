/*
  Difficulty: Medium

  Given a sorted array of integers, find the starting and ending position of a given target value.

  Your algorithm’s runtime complexity must be in the order of O(log n).

  If the target is not found in the array, return [-1, -1].

  Example:

  Given [5, 7, 7, 8, 8, 10]

  and target value 8,

  return [3, 4].
*/

public class Solution {
  // DO NOT MODIFY THE LIST
  public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
    ArrayList<Integer> result = new ArrayList();

    int start = 0, end = a.size() - 1, mid = 0;

    // first binarySearch find the start
    while(start <= end) {
      mid = (start + end) / 2;

      if(a.get(mid) == b && (mid == 0 || a.get(mid - 1) != b)) {
        result.add(mid);
        break;
      } else if(a.get(mid) < b) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    // if first binarySearch can't even find it then return -1s
    if(result.size() == 0) {
      result.add(-1);
      result.add(-1);

      return result;
    }

    // reset the pointers, but set the start to the known start
    start = result.get(0);
    end = a.size() - 1;

    // second binarySearch finds the end
    while(start <= end) {
      mid = (start + end) / 2;

      if(a.get(mid) == b && (mid == a.size() - 1 || a.get(mid + 1) != b)) {
        result.add(mid);
        break;
      } else if(a.get(mid) > b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return result;
  }
}
