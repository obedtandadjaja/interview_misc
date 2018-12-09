// Difficulty: Easy
// Runtime: 9 ms, faster than 91.81% of Java online submissions for Ransom Note.
//
// Given an arbitrary ransom note string and another string containing letters from all the
// magazines, write a function that will return true if the ransom note can be constructed
// from the magazines ; otherwise, it will return false.
// 
// Each letter in the magazine string can only be used once in your ransom note.
//
//    Note: You may assume that both strings contain only lowercase letters.
//
//    canConstruct("a", "b") -> false
//    canConstruct("aa", "ab") -> false
//    canConstruct("aa", "aab") -> true

class RansomNote {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "aaa"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() == 0) return true;
        if(ransomNote.length() > magazine.length()) return false;

        int remaining_chars = ransomNote.length();
        int[] ransom_char_count = new int[255];
        for(char c : ransomNote.toCharArray()) ransom_char_count[c - '0'] += 1;

        for(char c : magazine.toCharArray()) {
            if(remaining_chars == 0) return true;

            int ord = c - '0';
            if(ransom_char_count[ord] > 0) {
                ransom_char_count[ord] -= 1;
                remaining_chars--;
            }
        }

        return remaining_chars == 0;
    }
}
