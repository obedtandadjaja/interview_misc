/*
	Difficulty: Easy

	Implement int sqrt(int x).

	Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

	Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

	Example 1:

	Input: 4
	Output: 2
	Example 2:

	Input: 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since
	the decimal part is truncated, 2 is returned.
 */

class Sqrt {
	public static void main(String[] args) {
		mySqrt(10);
	}

  public static int mySqrt(int x) {
    long l = 0;
    long r = x;
    long ans = 0;

    while(l <= r) {
      long mid = (l+r)/2;
      long square = mid*mid;

      if(square < x) {
        l = mid+1;
        ans = mid;
      } else if(square > x) {
        r = mid-1;
      } else {
        return (int) mid;
      }
    }

    return (int) ans;
  }
}
