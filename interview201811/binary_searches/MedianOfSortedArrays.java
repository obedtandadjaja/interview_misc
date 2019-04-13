/*
  Difficulty: Hard

  There are two sorted arrays A and B of size m and n respectively.

  Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

  The overall run time complexity should be O(log (m+n)).

  Sample Input

  A : [1 4 5]
  B : [2 3]

  Sample Output
  3
*/

public class Solution {
  // DO NOT MODIFY BOTH THE LISTS
  public double findMedianSortedArrays(final List<Integer> A, final List<Integer> B) {
    int len = A.size() + B.size();

    if(len % 2 == 1)
      return findKth(A, 0, B, 0, len / 2 + 1);
    else
      return (findKth(A, 0, B, 0, len / 2) +
              findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
  }

  // finding Kth element - divide and conquer
  // idea is to keep searching for k / 2
  public int findKth(List<Integer> A, int A_start, List<Integer> B, int B_start, int k){
    // if one of the array size is 0 then return the other
    if(A_start >= A.size())
      return B.get(B_start + k - 1);
    if(B_start >= B.size())
      return A.get(A_start + k - 1);

    // the min of the two pointers is the answer
    if(k == 1)
      return Math.min(A.get(A_start), B.get(B_start));

    // values for A and B
    int A_key = Integer.MAX_VALUE, B_key = Integer.MAX_VALUE;

    // compare next values by k / 2
    // k / 2 because we are dividing k to 2 for A and B
    if(A_start + k / 2 - 1 < A.size())
      A_key = A.get(A_start + k / 2 - 1);
    if(B_start + k / 2 - 1 < B.size())
      B_key = B.get(B_start + k / 2 - 1);

    // recurse to the smaller of the two
    if(A_key < B_key)
      return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
    else
      return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
  }
}
