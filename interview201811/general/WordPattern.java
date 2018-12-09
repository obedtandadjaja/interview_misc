// Difficulty: Easy
// Runtime: 1 ms, faster than 99.08% of Java online submissions for Word Pattern.

// Given a pattern and a string str, find if str follows the same pattern.
// Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

//     Example 1:

//     Input: pattern = "abba", str = "dog cat cat dog"
//     Output: true
//     Example 2:

//     Input:pattern = "abba", str = "dog cat cat fish"
//     Output: false
//     Example 3:

//     Input: pattern = "aaaa", str = "dog cat cat dog"
//     Output: false
//     Example 4:

//     Input: pattern = "abba", str = "dog dog dog dog"
//     Output: false
//     Notes:
//     You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

import java.util.*;

class WordPattern {
    public static void main(String[] args) {
        wordPattern("abba", "dog cat cat dog");
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] word_dict = new String[26];
        HashSet<String> taken_words = new HashSet<>();

        String[] words = str.split(" ");

        if(pattern.length() != words.length) return false;

        for(int i = 0; i < pattern.length(); i++) {
            if(taken_words.contains(words[i])) return false;

            int dict_index = pattern.charAt(i) - 'a';
            if(word_dict[dict_index] == null) {
                word_dict[dict_index] = words[i];
                taken_words.add(words[i]);
            } else {
                if(!word_dict[dict_index].equals(words[i])) return false;
            }
        }

        return true;
    }
}
