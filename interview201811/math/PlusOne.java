/*
	Difficulty: Easy
  Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.

	Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

	The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

	You may assume the integer does not contain any leading zero, except the number 0 itself.

	Example 1:

	Input: [1,2,3]
	Output: [1,2,4]
	Explanation: The array represents the integer 123.
	Example 2:

	Input: [4,3,2,1]
	Output: [4,3,2,2]
	Explanation: The array represents the integer 4321.
 */

class PlusOne {
	public static void main(String[] args) {
		int[] digits = new int[] { 4,3,2,1 };
		plusOne(digits);
	}

  public static int[] plusOne(int[] digits) {
    int carry = 1;

    for(int i = digits.length-1; i >= 0; i--) {
      digits[i] += carry;
      carry = digits[i] / 10;

      if(digits[i] >= 10) digits[i] %= 10;
    }

    // the only possible case for this is: 9, 99, 999, 9999, ...
    if(carry == 1) {
      int[] result = new int[digits.length+1];
      result[0] = 1;
      return result;
    }

    return digits;
  }
}
