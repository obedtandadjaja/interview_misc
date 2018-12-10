/*
	Difficulty: Easy
	Runtime: 6 ms, faster than 72.49% of Java online submissions for Valid Palindrome.

	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	Note: For the purpose of this problem, we define empty string as valid palindrome.

	Example 1:

	Input: "A man, a plan, a canal: Panama"
	Output: true
	Example 2:

	Input: "race a car"
	Output: false
 */

class ValidPalindrome {
	public static void main(String[] args) {
		isPalindrome("Hello.. % %% oLLeH");
	}

	// using Regex to get only alphanumeric characters
	// cleaner but at the cost of performance
  public static boolean isPalindrome(String s) {
    String str = s.replaceAll("[^\\w\\d]", "").toLowerCase();

    for(int i = 0; i < str.length()/2; i++)
      if(str.charAt(i) != str.charAt(str.length()-1-i))
        return false;

    return true;
  }

	// looping through as we go and checking valid characters only
	// have 2 loops from the back and from the front
  public static boolean isPalindrome2(String s) {
    int length = s.length();
    int left_idx = 0;
    int right_idx = length - 1;

    while(left_idx < right_idx) {
      while(left_idx < length && !isAlphanumeric(s.charAt(left_idx))) left_idx++;
      if(left_idx >= length) return true;

      while(right_idx >= 0 && !isAlphanumeric(s.charAt(right_idx))) right_idx--;
      if(right_idx <= 0) return true;

      if(left_idx > right_idx) return true;
      if(!isEqual(s.charAt(left_idx), s.charAt(right_idx))) return false;

      left_idx++;
      right_idx--;
    }

    return true;
  }

  public static boolean isAlphanumeric(char c) {
    return Character.isDigit(c) || Character.isLetter(c);
  }

  public static boolean isEqual(char c1, char c2) {
    return Character.toLowerCase(c1) == Character.toLowerCase(c2);
  }
}
