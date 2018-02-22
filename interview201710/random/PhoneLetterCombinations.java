/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/

import java.util.*;

class PhoneLetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits).toString());
    }

    List<String> l = new ArrayList<String>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.indexOf("0") > -1 || digits.indexOf("1") > 1 || digits.length() == 0) return l;
        getCombination(digits, 0, "");
        return l;
    }
    
    public void getCombination(String digits, int digitIndex, String result) {
        if(digitIndex >= digits.length()) {
            l.add(result);
            return;
        }
        
        int digit = digits.charAt(digitIndex) - '0';
        int add = (digit - 2) * 3;
        if(digit == 7 || digit == 9) {
            if(digit == 9) add++;
            getCombination(digits, digitIndex + 1, result + (char)('a' + add));
            getCombination(digits, digitIndex + 1, result + (char)('a' + add + 1));
            getCombination(digits, digitIndex + 1, result + (char)('a' + add + 2));
            getCombination(digits, digitIndex + 1, result + (char)('a' + add + 3));
        } else {
            if(digit == 8) add++;
            getCombination(digits, digitIndex + 1, result + (char)('a' + add));
            getCombination(digits, digitIndex + 1, result + (char)('a' + add + 1));
            getCombination(digits, digitIndex + 1, result + (char)('a' + add + 2));
        }
        
    }
    
    public List<String> letterCombinations2(String digits) {
        ArrayList<String> array = new ArrayList<>();
        if(digits.length() == 0) return array;
        
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        
        int firstDigit = digits.charAt(0) - '0';
        for(int i = 0; i < mapping[firstDigit].length(); i++) {
            Stack<String> s = new Stack<>();
            s.push("" + mapping[firstDigit].charAt(i));
            
            while(!s.empty()) {
                String curr = s.pop();
                int index = curr.length();
                
                if(index < digits.length()) {
                    int digit = digits.charAt(index) - '0';
                    for(int j = 0; j < mapping[digit].length(); j++) 
                        s.push(curr + mapping[digit].charAt(j));  
                } else {
                    array.add(curr);
                }
            }
        }
        
        return array;
    }
}
