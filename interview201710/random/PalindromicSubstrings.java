/*
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

Note:
The input string length won't exceed 1000.
*/

class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "adfasdfhasdjhfq8kaskdfha";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += getPalindromes(s, i, i);
            count += getPalindromes(s, i, i+1);
        }
        
        return count;
    }
    
    private static int getPalindromes(String s, int start, int end) {
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
