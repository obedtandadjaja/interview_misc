/*
	Difficulty: Easy
	Runtime: 3 ms, faster than 100.00% of Java online submissions for Shortest Distance to a Character.

	Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.

	Example 1:

	Input: S = "loveleetcode", C = 'e'
	Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

	Note:

	S string length is in [1, 10000].
	C is a single character, and guaranteed to be in string S.
	All letters in S and C are lowercase.
*/

class ShortestDistanceToACharacter {
	public static void main(String[] args) {
		shortestToChar("leetcode", 'e');
	}

  public static int[] shortestToChar(String S, char C) {
    int[] results = new int[S.length()];

    int first_idx = S.indexOf(C);
    int previous_idx = first_idx;

    for(int i = first_idx; i >= 0; i--) results[i] = first_idx - i;

    for(int i = first_idx + 1; i < S.length(); i++) {
      if(S.charAt(i) == C) {
        for(int j = i-1; j >= ((previous_idx+i)/2)+1; j--) results[j] = i-j;

        results[i] = 0;
        previous_idx = i;
      } else {
        results[i] = i-previous_idx;
      }
    }

    return results;
  }
}
