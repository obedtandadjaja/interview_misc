/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
*/

import java.util.*;

class BasicCalculator2 {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) current = current*10 + s.charAt(i)-'0';
            
            // not else if to also calculate the end
            if((!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ') || i == s.length()-1) {    
                if(sign == '+') {
                    stack.push(current);
                } else if(sign == '-') {
                    stack.push(-current);
                } else if(sign == '*') {
                    stack.push(stack.pop()*current);
                } else if(sign == '/') {
                    stack.push(stack.pop()/current);
                }
                
                current = 0;
                sign = s.charAt(i);
            }
        }
        
        int result = 0;
        for(int i : stack) result += i;
        
        return result;
    }
}
