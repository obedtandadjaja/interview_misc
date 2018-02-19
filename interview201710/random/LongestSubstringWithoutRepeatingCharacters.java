/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

import java.util.*;

class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abasdbcsdafwfgqfqwe";
        System.out.println(lengthOfLongestSubstring(s);
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        
        StringBuilder curr = new StringBuilder(s.substring(0, 1));
        int max = 1;
        
        for(int i = 1; i < s.length(); i++) {
            curr.delete(0, curr.indexOf("" + s.charAt(i)) + 1);
            curr.append(s.charAt(i));
            max = Math.max(max, curr.length());
        }
        
        return max;
    }
}
