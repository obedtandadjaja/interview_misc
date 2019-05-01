/*
  Difficulty: Medium

  Implement atoi to convert a string to an integer.

  Example :

  Input : "9 2704"
  Output : 9
  Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

  Questions: Q1. Does string contain whitespace characters before the number?
  A. Yes Q2. Can the string have garbage characters after the number?
  A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
  A. Return 0. Q4. What if the integer overflows?
  A. Return INT_MAX if the number is positive, INT_MIN otherwise. 
 */

public class Solution {
  // DO NOT MODIFY THE LIST. IT IS READ ONLY
  public int atoi(final String A) {
    long curr = 0L;

    int index = 0;

    while(index < A.length() && A.charAt(index) == ' ')
      index++;

    boolean isNegative = false;
    if(index < A.length() && A.charAt(index) == '-') {
      isNegative = true;
      index++;
    } else if(index < A.length() && A.charAt(index) == '+') {
      isNegative = false;
      index++;
    }

    while(index < A.length() && Character.isDigit(A.charAt(index))) {
      curr *= 10;
      curr += (A.charAt(index) - '0') * (isNegative ? -1 : 1);

      if(curr > Integer.MAX_VALUE) return Integer.MAX_VALUE;
      if(curr < Integer.MIN_VALUE) return Integer.MIN_VALUE;
      index++;
    }

    return (int) curr;
  }
}
