/*
  Difficulty: Medium

  Given the coordinates of four points in 2D space, return whether the four points could construct a square.

  The coordinate (x,y) of a point is represented by an integer array with two integers.

  Example:
  Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
  Output: True
 */
class Solution {
  // 1: sort the coordinates by x then by y
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int[][] coordinates = new int[][] { p1, p2, p3, p4 };
    Arrays.sort(coordinates, (a, b) -> {
      if(a[0] == b[0]) {
        return a[1] - b[1];
      } else {
        return a[0] - b[0];
      }
    });

    if(dist(coordinates[0], coordinates[1]) == 0)
      return false;

    return dist(coordinates[0], coordinates[1]) ==
           dist(coordinates[1], coordinates[3]) &&
           dist(coordinates[1], coordinates[3]) ==
           dist(coordinates[3], coordinates[2]) &&
           dist(coordinates[3], coordinates[2]) ==
           dist(coordinates[2], coordinates[0]) &&
           dist(coordinates[0], coordinates[3]) ==
           dist(coordinates[1], coordinates[2]);
  }

  // 2: try every distinct permutation directly
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
  }

  public boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
    return dist(p1, p2) > 0 &&
           dist(p1, p2) == dist(p2, p3) &&
           dist(p2, p3) == dist(p3, p4) &&
           dist(p3, p4) == dist(p4, p1) &&
           dist(p1, p3) == dist(p2, p4);
  }

  public double dist(int[] c1, int[] c2) {
    return (c2[0] - c1[0]) * (c2[0] - c1[0]) + (c2[1] - c1[1]) * (c2[1] - c1[1]);
  }
}/*
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
