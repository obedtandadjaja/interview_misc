/*
  Difficulty: Medium

  Given an array of integers, every element appears thrice except for one which occurs once.

  Find that element which does not appear thrice.

  Note: Your algorithm should have a linear runtime complexity.

  Could you implement it without using extra memory?

  Example :

  Input : [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
  Output : 4
 */
public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int singleNumber(final List<Integer> A) {
    // do a bit count
    int[] bitCount = new int[32];

    for (int x : A) {
      int mask = 1;

      for (int i = 0; i < 32; ++i) {
        if ((x & mask) > 0)
          bitCount[i] += 1;

        mask = mask << 1;
      }
    }

    int result = 0;

    // iterate over the bit count
    int mask = 1;
    for (int i = 0; i < 32; ++i) {
      if (bitCount[i] % 3 != 0) // if bit is not a multiple of 3
        result = result | mask;

      mask = mask << 1;
    }

    return result;
  }
}
