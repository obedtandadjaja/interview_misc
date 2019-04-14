/*
  Difficulty: Medium

  Remove duplicates from Sorted Array
  Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.

  Note that even though we want you to return the new length, make sure to change the original array as well in place

  Do not allocate extra space for another array, you must do this in place with constant memory.

  Example:
  Given input array A = [1,1,2],
  Your function should return length = 2, and A is now [1,2].
 */

public class Solution {
  public int removeDuplicates(ArrayList<Integer> a) {
    if(a.size() <= 1) return a.size();

    // have 2 pointers, curr pointing to the current index to change
    // fast pointer points to the first next occurrence of the next value
    int curr = 0;
    int fast = 0;

    while(fast < a.size()) {
      int prevFast = fast; // need to maintain this so that we know whether it changed
      while(fast < a.size() && a.get(fast) - a.get(prevFast) == 0) {
        fast++;
      }

      a.set(curr, a.get(fast - 1));
      curr++;
    }

    return curr;
  }
}
