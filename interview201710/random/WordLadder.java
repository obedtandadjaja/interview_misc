/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
*/

import java.util.*;

class WordLadder {
    public static void main(String[] args) {
        String beginWord = "dig";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        HashSet<String> wordSet = new HashSet<>(wordList);
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        
        int ladderLength = 1;
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
            if(beginSet.size() > endSet.size()) {
                HashSet<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            HashSet<String> temp = new HashSet<String>();
            for(String word : beginSet) {
                char[] wordChars = word.toCharArray();
                
                for(int i = 0; i < wordChars.length; i++) {
                    char oldChar = wordChars[i];
                    
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordChars[i] = c;
                        String newWord = String.valueOf(wordChars);
                        
                        if(endSet.contains(newWord)) {
                            return ladderLength + 1;
                        }
                        
                        if(wordSet.contains(newWord)) {
                            temp.add(newWord);
                            wordSet.remove(newWord);
                        }                        
                    }
                    
                    wordChars[i] = oldChar;
                }
            }
            
            beginSet = temp;
            ladderLength++;
        }
        
        return 0;
    }
}
