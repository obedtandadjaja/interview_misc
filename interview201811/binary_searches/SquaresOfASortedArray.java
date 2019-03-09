/*
  Difficulty: Medium

  Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

  Example 1:

  Input: [-4,-1,0,3,10]
  Output: [0,1,9,16,100]
  Example 2:

  Input: [-7,-3,2,3,11]
  Output: [4,9,9,49,121]

  Note:

  1 <= A.length <= 10000
  -10000 <= A[i] <= 10000
  A is sorted in non-decreasing order.
 */

class Solution {
  public int[] sortedSquares(int[] A) {
    int[] result = new int[A.length];

    // search for zero / start of positive number
    boolean found = false;

    int left = 0;
    int right = A.length - 1;
    int mid = 0;
    while(left <= right) {
      mid = (left + right) / 2;

      if(A[mid] < 0) left = mid + 1;
      else if(A[mid] > 0) right = mid - 1;
      else {
        found = true;
        break;
      }
    }

    // if found use mid, if not then use left or right
    if(found) {
      left = mid;
      right = mid + 1;
    } else {
      left = right;
      right++;
    }

    // sort the array
    int resultIndex = 0;
    while(left >= 0 || right < A.length) {
      if(left == -1) {
        result[resultIndex++] = A[right] * A[right];
        right++;
      } else if(right == A.length) {
        result[resultIndex++] = A[left] * A[left];
        left--;
      } else if(-A[left] < A[right]) {
        result[resultIndex++] = A[left] * A[left];
        left--;
      } else {
        result[resultIndex++] = A[right] * A[right];
        right++;
      }
    }

    return result;
  }
}
