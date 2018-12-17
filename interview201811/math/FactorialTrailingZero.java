/*
  Difficulty: Easy

  Given an integer n, return the number of trailing zeroes in n!.

  Example 1:

  Input: 3
  Output: 0
  Explanation: 3! = 6, no trailing zero.
  Example 2:

  Input: 5
  Output: 1
  Explanation: 5! = 120, one trailing zero.
  Note: Your solution should be in logarithmic time complexity.
 */

class FactorialTrailingZero {
  // 5! = 120
  // 10! = 3628800
  // every multiple of 5 factorials, adds a trailing zero
  public int trailingZeroes(int n) {
    int count = 0;
    while(n > 4) {
      n /= 5;
      count += n;
    }

    return count;
  }
}
