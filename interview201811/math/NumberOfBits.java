/*
	Difficulty: Easy

	Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).

	Example 1:

	Input: 11
	Output: 3
	Explanation: Integer 11 has binary representation 00000000000000000000000000001011 
	Example 2:

	Input: 128
	Output: 1
	Explanation: Integer 128 has binary representation 00000000000000000000000010000000
 */

public class NumberOfBits {
  /*
		Instead of checking every bit of the number, we repeatedly flip the
		least-significant 11-bit of the number to 00, and add 11 to the sum.
		As soon as the number becomes 00, we know that it does not have any '
		more 11-bits, and we return the sum.

		The key idea here is to realize that for any number nn, doing a bit-wise
		AND of nn and n - 1n−1 flips the least-significant 11-bit in nn to 00.
		Why? Consider the binary representations of nn and n - 1n−1.
  */
  public int hammingWeight(int n) {
    int count = 0;
    while(n != 0) {
      count++;
      n &= n-1;
    }

    return count;
  }
}
