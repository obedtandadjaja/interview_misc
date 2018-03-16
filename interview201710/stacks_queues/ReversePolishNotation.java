/*

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

import java.util.*;

class ReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<Integer>();

        for(String token : tokens) {
            if(token.equals("+")) {
                s.push(s.pop() + s.pop());
            } else if(token.equals("-")) {
                int subtractor = s.pop();
                s.push(s.pop() - subtractor);
            } else if(token.equals("*")) {
                s.push(s.pop() * s.pop());
            } else if(token.equals("/")) {
                int divider = s.pop();
                s.push(s.pop() / divider);
            } else {
                s.push(Integer.parseInt(token));
            }
        }

        return s.pop();
    }
}
