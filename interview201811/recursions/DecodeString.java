/*
  Difficulty: Medium

  Given an encoded string, return it's decoded string.

  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

  You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

  Examples:

  s = "3[a]2[bc]", return "aaabcbc".
  s = "3[a2[c]]", return "accaccacc".
  s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

class Solution {
  public String decodeString(String s) {
    return decode(s, 0).str;
  }

  public Result decode(String s, int index) {
    if(index >= s.length()) return new Result("", index);

    StringBuilder result = new StringBuilder();
    while(index < s.length()) {
      if(Character.isLetter(s.charAt(index))) {
        String str = getString(s, index);
        index += str.length();
        result.append(str);
      } else if(Character.isDigit(s.charAt(index))){
        int repetition = getNumber(s, index);

        index += String.valueOf(repetition).length();
        index++; // skip [

        Result childResult = decode(s, index);
        index = childResult.index;

        while(repetition >= 1) {
          result.append(childResult.str);
          repetition--;
        }

        index++; // skip ]
      } else {
        break;
      }
    }

    return new Result(result.toString(), index);
  }

  public String getString(String s, int index) {
    StringBuilder sb = new StringBuilder();
    while(index < s.length() && Character.isLetter(s.charAt(index))) {
      sb.append(s.charAt(index));
      index++;
    }

    return sb.toString();
  }

  public int getNumber(String s, int index) {
    int num = 0;
    while(index < s.length() && Character.isDigit(s.charAt(index))) {
      num *= 10;
      num += (s.charAt(index) - '0');
      index++;
    }

    return num;
  }

  public class Result {
    String str;
    int index;

    Result(String str, int index) {
      this.str = str;
      this.index = index;
    }
  }
}
