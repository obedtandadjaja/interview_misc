/*
	Difficulty: Easy

	Given an integer, write a function to determine if it is a power of three.

	Example 1:

	Input: 27
	Output: true
	Example 2:

	Input: 0
	Output: false
	Example 3:

	Input: 9
	Output: true
	Example 4:

	Input: 45
	Output: false
	Follow up:
	Could you do it without using any loop / recursion?
 */

import java.lang.Math;

class PowerOfThree {
	public static void main(String[] args) {
		isPowerOfThree(9);
	}

  // iterative
  public static boolean isPowerOfThree(int n) {
    long i = 1;
    while(i < n) i *= 3;
    return i == n;
  }

  // base conversion with regex
  public static boolean isPowerOfThree(int n) {
    return Integer.toString(n, 3).matches("^10*$");
  }

  // log3(n) = log10(n)/log10(3)
  public static boolean isPowerOfThree(int n) {
    return (Math.log10(n) / Math.log10(3)) % 1 == 0;
  }

  // 1162261467 = log3(Integer.MAX_VALUE)
  // because 3 is a prime number, the only divisor of 3^n is 3^n-1 to 3^1
  public static boolean isPowerOfThree(int n) {
    return n > 0 && 1162261467 % n == 0;
  }
}
