/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>>[] dp = (List<List<String>>[]) new ArrayList<?>[s.length()];

        return helper(s, 0, dp);
    }

    public List<List<String>> helper(String s, int start, List<List<String>>[] dp) {
        if(start == s.length()) {
            return null;
        } else if(start == s.length()-1) {
            if(dp[start] == null) dp[start] = new ArrayList<List<String>>();

            if(dp[start].size() > 0) return dp[start];

            ArrayList<String> l = new ArrayList<String>();
            l.add(String.valueOf(s.charAt(start)));
            dp[start].add(l);

            return dp[start];
        } else if(dp[start] != null) {

            return dp[start];

        } else {
            if(dp[start] == null) dp[start] = new ArrayList<List<String>>();

            StringBuilder curr = new StringBuilder();
            for(int i = start; i < s.length(); i++) {
                curr.append(s.charAt(i));

                // check if palindrome
                if(isPalindrome(curr.toString())) {
                    List<List<String>> result = helper(s, i+1, dp);
                    if(result == null) {

                        ArrayList<String> entry = new ArrayList<String>();
                        entry.add(curr.toString());
                        dp[start].add(entry);

                    } else {
                        for(int j = 0; j < result.size(); j++) {
                            ArrayList<String> entry = (ArrayList)((ArrayList) result.get(j)).clone();
                            entry.add(0, curr.toString());
                            dp[start].add(entry);
                        }
                    }
                }
            }
            return dp[start];
        }
    }

    public boolean isPalindrome(String str) {
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
        }
        return true;
    }
}
