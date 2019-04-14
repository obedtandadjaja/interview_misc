/*
  Difficulty: Medium

  Given two numbers represented as strings, return multiplication of the numbers as a string.

  Note: The numbers can be arbitrarily large and are non-negative.
  Note2: Your answer should not have leading zeroes. For example, 00 is not a valid answer.
  For example,
  given strings "12", "10", your answer should be “120”.
 */
public class Solution {
  public String multiply(String A, String B) {
    String longerString = A.length() >= B.length() ? A : B;
    String shorterString = A.length() < B.length() ? A : B;

    int[][] additions = new int[shorterString.length()][longerString.length() + 1 + shorterString.length() - 1];

    for(int i = 0; i < shorterString.length(); i++) {
      int carry = 0;
      for(int j = 0; j < longerString.length(); j++) {
        additions[i][additions[i].length - 1 - j - i] =
          (shorterString.charAt(shorterString.length() - 1 - i) - '0') *
          (longerString.charAt(longerString.length() - 1 - j) - '0') +
          carry;

        carry = additions[i][additions[i].length - 1 - j - i] / 10;
        additions[i][additions[i].length - 1 - j - i] %= 10;
      }

      if(carry > 0) {
        additions[i][additions[i].length - 1 - longerString.length() - i] = carry;
      }
    }

    StringBuilder sb = new StringBuilder();
    int sum = 0;
    for(int i = additions[0].length - 1; i >= 0; i--) {
      for(int j = 0; j < additions.length; j++) {
        sum += additions[j][i];
      }

      sb.insert(0, sum % 10);
      sum = sum / 10;
    }
    if(sum / 10 > 0) sb.insert(0, sum / 10);

    int firstNonZero = sb.length() - 1;
    for(int i = 0; i < sb.length(); i++) {
      if(sb.charAt(i) != '0') {
        firstNonZero = i;
        break;
      }
    }

    return sb.substring(firstNonZero);
  }
}
