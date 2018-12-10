/*
	Difficulty: Easy
  Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Anagram.

	Given two strings s and t , write a function to determine if t is an anagram of s.

	Example 1:

	Input: s = "anagram", t = "nagaram"
	Output: true
	Example 2:

	Input: s = "rat", t = "car"
	Output: false
	Note:
	You may assume the string contains only lowercase alphabets.
 */

class ValidAnagram {
	public static void main(String[] args) {
		isAnagram("anagram", "nagaram");
	}

  public static boolean isAnagram(String s, String t) {
    if(s.length() != t.length()) return false;

    int[] cache = new int[26];
    for(char c : s.toCharArray()) cache[c - 'a']++;

    for(char c : t.toCharArray()) {
      if(cache[c - 'a'] == 0) return false;
      cache[c - 'a']--;
    }

    return true;
  }
}
