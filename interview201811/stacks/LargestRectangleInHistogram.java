/*
  Difficulty: Medium

  Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

  Largest Rectangle in Histogram: Example 1
  Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
  return 10.
*/

public class Solution {
  // idea: use monotonous stack to only track increasing order
  // treat each bar as its min height and calculate height to prev and next bars bigger than curr
  public int largestRectangleArea(ArrayList<Integer> A) {
    if(A.size() == 0) return 0;

    Stack<Integer> stack = new Stack();

    int max = 0;
    for(int i = 0; i < A.size(); i++) {
      // only keep increasing order, if not calculate their areas
      while(!stack.isEmpty() && A.get(stack.peek()) > A.get(i)) {
        int curr = stack.pop();
        int prev = stack.isEmpty() ? 0 : stack.peek() + 1;

        // calculate left and right width with height = curr
        int left = curr - prev;
        int right = i - 1 - curr;

        int area = (left + right + 1) * A.get(curr);
        max = Math.max(max, area);
      }

      stack.push(i);
    }

    // empty the stack and calculate the area
    while(!stack.isEmpty()) {
      int curr = stack.pop();
      int prev = stack.isEmpty() ? 0 : stack.peek() + 1;

      int left = curr - prev;
      int right = A.size() - 1 - curr;

      int area = (left + right + 1) * A.get(curr);
      max = Math.max(max, area);
    }

    return max;
  }
}
