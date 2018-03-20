/*
 Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s 
 can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary
 does not contain duplicate words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code". 
*/

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> failed = new HashSet<String>(); // keep track of all failed trials
        return recurse(wordDict, s, failed);
    }
    
    public boolean recurse(List<String> dict, String word, HashSet<String> failed) {
        if(word.length() == 0) return true;
        if(failed.contains(word)) return false;
        
        for(int i = 0; i < dict.size(); i++) {
            String curr = dict.get(i);
            if(word.startsWith(curr)) {
                if(recurse(dict, word.substring(curr.length(), word.length()), failed)) return true;
                else failed.add(word.substring(curr.length(), word.length()));
            }
        }
        
        return false;
    }
    
    // iterative solution
    public boolean wordBreakIterative(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
