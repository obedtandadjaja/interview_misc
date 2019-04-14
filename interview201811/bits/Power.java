/*
  Difficulty: Medium

  Implement pow(x, n) % d.

  In other words, given x, n and d,

  find (xn % d)

  Note that remainders on division cannot be negative. 
  In other words, make sure the answer you return is non negative.

  Input : x = 2, n = 3, d = 3
  Output : 2

  2^3 % 3 = 8 % 3 = 2.
*/

public class Solution {
  // idea is that we can do better than O(N)
  // note that 3^8 = 3^4 * 3^4
  // so 3^7 = 3^4 * 3^2 * 3^1 since 7 (0111)
  // similary 3^5 = 3^4 * 3^1 since 5 (0101)
  public int pow(int x, int n, int d) {
    if (n==0) return 1 % d;
    if (n==1) {
      if (x < 0) return (x + d) % d;
      return x % d;
    }

    int result = 1;
    int currX = x % d;

    while (n > 0) {
      // only apply when least significant bit is 1
      if (n % 2 == 1)
        result = (result * currX) % d;

      // double the product
      n /= 2;
      currX = (currX * currX) % d;
    }

    return (result + d) % d;
  }
}
