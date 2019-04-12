/*
  Difficulty: Medium

  Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].

  If there is no solution possible, return -1.

  Example :

  A : [3 5 4 2]

  Output : 2
  for the pair (3, 4)
*/

public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY

  // 1: use list and hashmap to store the index and the value of the mins
  //    idea is that you only insert to the list if there is an element
  //    that is smaller than the first index. The order of insertion is important
  //    the last element will be the biggest but also the smallest index
  public int maximumGap(final List<Integer> A) {
    if(A.size() == 1) return 0;

    int max = 0;

    // use list to store the minimums only - list.get(0) = smallest
    // use hashmap to store the index
    HashMap<Integer, Integer> map = new HashMap();
    List<Integer> list = new ArrayList();

    // initate the min
    list.add(A.get(0));
    map.put(A.get(0), 0);

    for(int i = 1; i < A.size(); i++) {
      // find the index in the array
      int listIndex = Collections.binarySearch(list, A.get(i));
      if(listIndex < 0) listIndex = listIndex * -1 - 2;

      // insert only if it is smaller than the smallest element in the list
      if(list.get(0) > A.get(i)) {
        list.add(0, A.get(i));
        map.put(A.get(i), i);
      } else { // else then there must be a smaller element in the list
        max = Math.max(max, i - map.get(list.get(listIndex)));
      }
    }

    return max;
  }

  // 2: use 2 arrays to track the min and max
  //    then use 2 pointers to find the max diff
  public int maximumGap(final List<Integer> A) {
    int maxDiff;
    int i, j;
    int n = A.size();

    int[] LMin = new int[n];
    int[] RMax = new int[n];

    /* Construct LMin[] such that LMin[i] stores the minimum value
       from (arr[0], arr[1], ... arr[i]) */
    LMin[0] = A.get(0);
    for (i = 1; i < n; i++) {
      LMin[i] = Math.min(A.get(i), LMin[i-1]);
    }

    /* Construct RMax[] such that RMax[j] stores the maximum value
       from (arr[j], arr[j+1], ..arr[n-1]) */
    RMax[n-1] = A.get(n-1);
    for (j = n-2; j >= 0; j--) {
      RMax[j] = Math.max(A.get(j), RMax[j+1]);
    }

    /* Traverse both arrays from left to right to find optimum j - i
       This process is similar to merge() of MergeSort */
    i = 0;
    j = 0;
    maxDiff = 0;
    while (j < n && i < n) {
      if (LMin[i] <= RMax[j]) {
        maxDiff = Math.max(maxDiff, j-i);
        j = j + 1;
      } else {
        i = i + 1;
      }
    }

    return maxDiff;
  }
}
