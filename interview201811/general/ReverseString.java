/*
	Difficulty: Easy
	Runtime: 2 ms, faster than 75.33% of Java online submissions for Reverse String.

	Write a function that takes a string as input and returns the string reversed.

	Example 1:

	Input: "hello"
	Output: "olleh"
	Example 2:

	Input: "A man, a plan, a canal: Panama"
	Output: "amanaP :lanac a ,nalp a ,nam A"

 */

class ReverseString {
	public static void main(String[] args) {
		reverseString("abcdefg");
	}

  public static String reverseString(String s) {
    char[] chars = s.toCharArray();

    char temp = ' ';
    for(int i = 0; i < chars.length/2; i++) {
      temp = chars[i];
      chars[i] = chars[chars.length-1-i];
      chars[chars.length-1-i] = temp;
    }

    return new String(chars);
  }
}
