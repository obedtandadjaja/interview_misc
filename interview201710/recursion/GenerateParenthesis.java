/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
*/

import java.util.*;

class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        getParenthesis(n, 1, "(", list);
        return list;
    }
    
    public static void getParenthesis(int target, int incomplete, String curr, List<String> list) {
        if(curr.length() >= target*2) {
            if(incomplete == 0) list.add(curr);
            return;
        }
        if(target*2 - curr.length() > incomplete) getParenthesis(target, incomplete + 1, curr + "(", list);
        if(incomplete > 0) getParenthesis(target, incomplete - 1, curr + ")", list);
    }
}
