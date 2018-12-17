/*
  Difficulty: Easy

  Given a column title as appear in an Excel sheet, return its corresponding column number.

  For example:

  A -> 1
  B -> 2
  C -> 3
  ...
  Z -> 26
  AA -> 27
  AB -> 28 
  ...
  Example 1:

  Input: "A"
  Output: 1
  Example 2:

  Input: "AB"
  Output: 28
  Example 3:

  Input: "ZY"
  Output: 701
 */

class TitleToNumber {
  public int titleToNumber(String s) {
    int num = 0;
    int multiplier = 1;
    for(int i = s.length() - 1; i >= 0; i--) {
      int char_to_num = s.charAt(i) - 'A' + 1;
      num += char_to_num * multiplier;

      multiplier *= 26;
    }

    return num;
  }
}
