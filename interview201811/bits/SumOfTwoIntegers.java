/*
	Difficulty: Easy
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Two Integers.

	Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

	Example 1:

	Input: a = 1, b = 2
	Output: 3
	Example 2:

	Input: a = -2, b = 3
	Output: 1
 */

class SumOfTwoIntegers {
	public static void main(String[] args) {
		getSum(2, 3);
	}

	public static int getSum(int a, int b) {
    if(b == 0) return a;

    int partialSum = a ^ b;
    int carry = (a & b) << 1;

    return getSum(partialSum, carry);
  }

  public static int getSum2(int a, int b) {
    boolean[] bits_a = new boolean[32];
    boolean[] bits_b = new boolean[32];
    boolean[] result_arr = new boolean[32];

    for(int i = 0; i < 32; i++) {
      bits_a[i] = (a & 1) == 1;
      a = a >> 1;
    }

    for(int i = 0; i < 32; i++) {
      bits_b[i] = (b & 1) == 1;
      b = b >> 1;
    }

    boolean carry = false;
    for(int i = 0; i < bits_a.length; i++) {
      result_arr[i] = bits_a[i] ^ bits_b[i] ^ carry;
      carry = (bits_a[i] && bits_b[i]) || (bits_a[i] && carry) || (bits_b[i] && carry);
    }

    int result = 0;
    for(int i = result_arr.length-1; i >= 0; i--) {
      result = result << 1;
      result |= result_arr[i] ? 1 : 0;
    }

    return result;
  }
}
