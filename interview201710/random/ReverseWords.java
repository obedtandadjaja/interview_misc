/*

Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.

click to show clarification.

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
 */

import java.util.*;

public class ReverseWords {

    public static void main(String[] args) {
      String s = "the sky is blue";
      System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = words.length-1; i >= 0; i--) {
            if(words[i].length() > 0) sb.append(words[i] + " ");
        }

        if(sb.length() > 0) sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}
