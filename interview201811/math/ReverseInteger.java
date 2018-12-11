/*
	Difficulty: Easy
	Runtime: 22 ms, faster than 84.73% of Java online submissions for Reverse Integer.

	Given a 32-bit signed integer, reverse digits of an integer.

	Example 1:

	Input: 123
	Output: 321
	Example 2:

	Input: -123
	Output: -321
	Example 3:

	Input: 120
	Output: 21
	Note:
	Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

import java.lang.Math;
import java.util.*;

class ReverseInteger {
	public static void main(String[] args) {
		reverse(204);
		reverse2(204);
	}

  public static int reverse(int x) {
    long result = 0;
    while(x != 0) {
      result = result * 10 + (x % 10);
      x /= 10;
    }

    return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int) result;
  }

  public static int reverse2(int x) {
    StringBuilder sb = new StringBuilder();
    sb.append(Math.abs(x));

    try {
      int result = Integer.parseInt(sb.reverse().toString());
      return x >= 0 ? result : -result;
    } catch(Exception e) {
      return 0;
    }
  }
}
