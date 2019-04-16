/*
  Difficulty: Medium

  Given a string s, partition s such that every string of the partition is a palindrome.

  Return all possible palindrome partitioning of s.

  For example, given s = "aab",
  Return

  [
  ["a","a","b"]
  ["aa","b"],
  ]
  Ordering the results in the answer : Entry i will come before Entry j if :
  len(Entryi[0]) < len(Entryj[0]) OR
  (len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
  *
  *
  *
  (len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
  In the given example,
  ["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
*/

public class Solution {
  public ArrayList<ArrayList<String>> partition(String a) {
    ArrayList<ArrayList<String>> result = new ArrayList();
    helper(result, new ArrayList(), a);

    return result;
  }

  public void helper(ArrayList<ArrayList<String>> result, ArrayList<String> currList, String a) {
    if(a.length() == 0) {
      result.add(new ArrayList(currList));
      return;
    }

    for(int i = 1; i <= a.length(); i++) {
      String substr = a.substring(0, i);

      if(isPalindrome(substr)) {
        currList.add(substr);
        helper(result, currList, a.substring(i, a.length()));
        currList.remove(currList.size() - 1);
      }
    }
  }

  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while(left <= right) {
      if(s.charAt(left) != s.charAt(right)) return false;

      left++;
      right--;
    }

    return true;
  }
}
