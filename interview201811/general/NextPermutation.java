/*
  Difficulty: Medium

  Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers.

  If such arrangement is not possible, it must be rearranged as the lowest possible order ie, sorted in an ascending order.

  The replacement must be in-place, do not allocate extra memory.

  Examples:

  1,2,3 → 1,3,2

  3,2,1 → 1,2,3

  1,1,5 → 1,5,1

  20, 50, 113 → 20, 113, 50
*/

public class Solution {
  // pattern:
  // The suffix which gets affected is in a descending order before the change.
  // A swap with the smaller element happens and then we reverse the affected suffix.
  // 1 2 3 -> 1 3 2   // Suffix being just the 3.
  // 1 2 3 6 5 4  -> 1 2 4 3 5 6 // Suffix being 6 5 4 in this case.
  public void nextPermutation(ArrayList<Integer> a) {
    if(a.size() <= 1) return;

    int index1 = a.size() - 2;

    // find the index of the number not in descending order
    while(index1 >= 0 && a.get(index1) >= a.get(index1 + 1)) {
      index1--;
    }

    if(index1 >= 0) {
      int index2 = a.size() - 1;

      // find number in descending order that is bigger than number to replace
      while(a.get(index1) >= a.get(index2)) {
        index2--;
      }

      swap(a, index1, index2);
    }

    reverse(a, index1 + 1, a.size() - 1);
  }

  public void reverse(ArrayList<Integer> a, int x, int y) {
    while(x < y) {
      swap(a, x++, y--);
    }
  }

  public void swap(ArrayList<Integer> a, int x, int y) {
    int temp = a.get(x);
    a.set(x, a.get(y));
    a.set(y, temp);
  }
}
