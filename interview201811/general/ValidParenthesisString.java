class Solution {
  public boolean checkValidString(String s) {
   Stack<Character> stack = new Stack();

   return helper(stack, s.toCharArray(), 0);
  }

  public boolean helper(Stack<Character> stack, char[] chars, int i) {
   if(i >= chars.length) return stack.isEmpty();

   if(chars[i] == ')') {
     if(stack.isEmpty()) return false;

     char curr = stack.peek();
     stack.pop();
     if(helper(stack, chars, i + 1)) return true;
     stack.push(curr);
   } else if(chars[i] == '*') {
     // 1: pop previous
     if(!stack.isEmpty()) {
       char curr = stack.peek();
       stack.pop();
       if(helper(stack, chars, i + 1)) return true;
       stack.push(curr);
     }

     // 2: add to stack
     stack.push(chars[i]);
     if(helper(stack, chars, i + 1)) return true;
     stack.pop();

     // 3: do nothing
     if(helper(stack, chars, i + 1)) return true;
   } else {
     stack.push(chars[i]);
     if(helper(stack, chars, i + 1)) return true;
     stack.pop();
   }

   return false;
  }

  // 2: greedy algorithm
  // When checking whether the string is valid, we only cared about the "balance"
  // if we have string '(***)', then as we parse each symbol,
  // the set of possible values for the balance is [1] for '(';
  // [0, 1, 2] for '(*';
  // [0, 1, 2, 3] for '(**';
  // [0, 1, 2, 3, 4] for '(***',
  // [0, 1, 2, 3] for '(***)'.
  public boolean checkValidString(String s) {
     int lo = 0, hi = 0;
     for (char c: s.toCharArray()) {
         lo += c == '(' ? 1 : -1;
         hi += c != ')' ? 1 : -1;

         if (hi < 0) break;

         lo = Math.max(lo, 0);
     }
     return lo == 0;
  }
}
