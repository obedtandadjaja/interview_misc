/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see 
below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You 
are responsible to gather all the input requirements up front.

Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first 
non-whitespace character is found. Then, starting from this character, takes an optional 
initial plus or minus sign followed by as many numerical digits as possible, and interprets 
them as a numerical value.

The string can contain additional characters after those that form the integral number, which 
are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, 
or if no such sequence exists because either str is empty or it contains only whitespace 
characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is 
out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

class StringToInteger {
    public static void main(String[] args) {
        String str = "2147483647";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        int result = 0;
        boolean found = false;
        boolean negative = false;

        for(int i = 0; i < str.length(); i++) {
            // skip whitespaces
            if(Character.isWhitespace(str.charAt(i)) && found)
                break;
            
            // skip letters
            if(Character.isLetter(str.charAt(i)))
                break;
            
            // signs
            if(str.charAt(i) == '-' || str.charAt(i) == '+') {
                if(found) break;
                found = true;
                negative = str.charAt(i) == '-';
            }

            // on digit
            if(Character.isDigit(str.charAt(i))) {
                found = true;
                long computed = result;
                computed = computed * 10 + (negative ? -(str.charAt(i) - '0') : str.charAt(i) - '0');
                if(computed > Integer.MAX_VALUE || computed < Integer.MIN_VALUE)
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                result = result * 10 + (negative ? -(str.charAt(i) - '0') : str.charAt(i) - '0');
            }
        }
        if(!found) return 0;
        if(!negative && result < 0 || negative && result > 0) 
            return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        return result;
    }
}
