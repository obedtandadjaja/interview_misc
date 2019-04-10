/*
	Difficulty: Easy
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
	Given a positive integer num, write a function which returns True if num is a perfect square else False.
	Note: Do not use any built-in library function such as sqrt.
	Example 1:
	Input: 16
	Output: true
	Example 2:
	Input: 14
	Output: false
 */

class ValidPerfectSquare {
	public static void main(String[] args) {
		isPerfectSquare(16);
	}

	// using sqrt difference - O(sqrt(N))
	// squares:    1 4 9 16 25 36
	// difference: 3 5 7 9 11
  public static boolean isPerfectSquare(int num) {
    if (num < 1) return false;
    for (int i = 1; num > 0; i += 2) num -= i;
    return num == 0;
  }

	// using BinarySearch - O(log N)
  public static boolean isPerfectSquare2(int num) {
    if(num == 0) return false;

    long left = 0;
    long right = num;

    while(left <= right) {
      long mid = (left + right)/2;
      long t = mid * mid;

      if(t == num) {
        return true;
      } else if(num > t) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

	// using Newton Method - almost constant time
  public static boolean isPerfectSquare3(int num) {
    if (num < 1) return false;

    long t = num / 2;
    while (t * t > num) {
      t = (t + num / t) / 2;
    }

    return t * t == num;
  }
}
