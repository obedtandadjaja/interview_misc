/*
  Difficulty: Medium

  A long array A[] is given to you. There is a sliding window of size w which is moving from the very left of the array to the very right. You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window. The following example will give you more clarity.

  Example :

  The array is [1 3 -1 -3 5 3 6 7], and w is 3.

  Window position    Max

  [1 3 -1] -3 5 3 6 7    3
  1 [3 -1 -3] 5 3 6 7    3
  1 3 [-1 -3 5] 3 6 7    5
  1 3 -1 [-3 5 3] 6 7    5
  1 3 -1 -3 [5 3 6] 7    6
  1 3 -1 -3 5 [3 6 7]    7
  Input: A long array A[], and a window width w
  Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
  Requirement: Find a good optimal way to get B[i]
*/

public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
    ArrayList<Integer> result = new ArrayList();

    // Use doubly linkedlist/deque to maintain local max
    // idea is that we don't care for lower numbers within the window
    Deque<Integer> q = new LinkedList();

    for(int i = 0; i < B; i++) {
      // if there is a smaller val in the queue then pop it since it will
      // never be returned ever
      while(!q.isEmpty() && A.get(q.getLast()) < A.get(i))
        q.removeLast();

      q.addLast(i);
    }

    // first element in the array is the local max
    result.add(A.get(q.getFirst()));

    for(int i = B; i < A.size(); i++) {
      // only remove the first element if the window overlaps
      if(q.getFirst() <= i - B) q.removeFirst();

      while(!q.isEmpty() && A.get(q.getLast()) < A.get(i))
        q.removeLast();

      q.addLast(i);
      result.add(A.get(q.getFirst()));
    }

    return result;
  }
}
