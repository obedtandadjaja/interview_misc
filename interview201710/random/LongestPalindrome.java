/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"
*/

import java.lang.Math;

class LongestPalindrome {
    public static void main(String[] args) {
        String s = "ababsdbasbababababababa";
        System.out.println(longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        
        int start = 0;
        int end = 1;
        
        for(int i = 1; i < s.length(); i++) {
            int len1 = expand(s, i-1, i);
            int len2 = expand(s, i, i);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len)/2;
                end = i + (len + 1)/2;
            }
        }
        
        return s.substring(start, end);
    }
    
    public int expand(String s, int start, int end) {
        while(start >= 0 && end <= s.length()-1 && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return end - (start+1);
    }
}
