/*
  Difficulty: Hard
  
  Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

  '.' Matches any single character.
  '*' Matches zero or more of the preceding element.
  The matching should cover the entire input string (not partial).

  Note:

  s could be empty and contains only lowercase letters a-z.
  p could be empty and contains only lowercase letters a-z, and characters like . or *.
  Example 1:

  Input:
  s = "aa"
  p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".
  Example 2:

  Input:
  s = "aa"
  p = "a*"
  Output: true
  Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
  Example 3:

  Input:
  s = "ab"
  p = ".*"
  Output: true
  Explanation: ".*" means "zero or more (*) of any character (.)".
  Example 4:

  Input:
  s = "aab"
  p = "c*a*b"
  Output: true
  Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
  Example 5:

  Input:
  s = "mississippi"
  p = "mis*is*p*."
  Output: false
 */

class Solution {
  public boolean isMatch(String s, String p) {
    return matching(s, p, 0, 0);
  }

  public boolean matching(String s, String p, int s_i, int p_i) {
    if(p.length() == p_i) return s.length() == s_i;

    if(s.length() == s_i || !isEqual(p.charAt(p_i), s.charAt(s_i))) {
      if(p_i + 1 < p.length() && p.charAt(p_i + 1) == '*')
        return matching(s, p, s_i, p_i + 2);

      return false;
    } else {
      if(p_i + 1 < p.length() && p.charAt(p_i + 1) == '*') {
        if(matching(s, p, s_i + 1, p_i)) return true;
        if(matching(s, p, s_i, p_i + 2)) return true;
      }

      return matching(s, p, s_i + 1, p_i + 1);
    }
  }

  public boolean isEqual(char c1, char c2) {
    if(c1 == '.' || c2 == '.') return true;

    return c1 == c2;
  }
}
