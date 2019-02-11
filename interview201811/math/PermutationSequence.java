/*
  Difficulty: Medium

  The set [1,2,3,...,n] contains a total of n! unique permutations.

  By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

  "123"
  "132"
  "213"
  "231"
  "312"
  "321"
  Given n and k, return the kth permutation sequence.

  Note:

  Given n will be between 1 and 9 inclusive.
  Given k will be between 1 and n! inclusive.
  Example 1:

  Input: n = 3, k = 3
  Output: "213"
  Example 2:

  Input: n = 4, k = 9
  Output: "2314"
 */

class Solution {
  // idea is 1234 is 1 + (permutation of 234)
  // there are n! (where n is the number of digits) possible permutations
  // do count/n! to get the digit to start
  // e.g. when count = 6 and n = 3, then the second index of [1,2,3] will start -> 3
  // repeat this until n downto 0
  public String getPermutation(int n, int k) {
    StringBuilder sb = new StringBuilder();

    int[] factorials = new int[n];
    ArrayList<Integer> list = new ArrayList<>();

    // construct list of numbers
    for(int i = 1; i <= n; i++) list.add(i);

    // construct factorials
    factorials[0] = 1;
    int sum = 1;
    for(int i = 1; i < n; i++) {
      sum *= i;
      factorials[i] = sum;
    }

    // decrement the repeat to start at 0
    k--;

    // last_index = count/n!
    // decrement count with the last_index * n! for the next permutation
    // when count == 0 then just exit the loop and dump the remaining sorted numbers to the result
    for(int i = n-1; i >= 0; i--) {
      int last_index = k / factorials[i];

      sb.append(list.get(last_index));
      list.remove(last_index);

      k -= last_index * factorials[i];

      if(k == 0) break;
    }

    for(int i = 0; i < list.size(); i++) sb.append(list.get(i));

    return sb.toString();
  }
}
