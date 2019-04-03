/*
  Difficulty: Hard

  Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

  Example 1:

  Input: "bcabc"
  Output: "abc"
  Example 2:

  Input: "cbacdcbc"
  Output: "acdb"
 */

class Solution {
  public String removeDuplicateLetters(String s) {
    int[] counters = new int[26];
    boolean[] visited = new boolean[26];
    Stack<Character> stack = new Stack<>();

    for(char c : s.toCharArray())
      counters[c - 'a']++;

    // use combination of visited and monotonous increasing stack
    for(char c : s.toCharArray()) {
      if(visited[c - 'a']) {
        counters[c - 'a']--;
        continue;
      }

      while(!stack.isEmpty() &&
            stack.peek() > c &&
            counters[stack.peek() - 'a'] > 1) {
        counters[stack.peek() - 'a']--;
        visited[stack.peek() - 'a'] = false;
        stack.pop();
      }

      stack.push(c);
      visited[c - 'a'] = true;
    }

    char[] result = new char[stack.size()];
    for(int i = stack.size() - 1; i >= 0; i--)
      result[i] = stack.pop();

    return new String(result);
  }
}
