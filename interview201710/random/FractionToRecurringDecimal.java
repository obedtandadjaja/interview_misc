/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */

import java.util.*;
import java.lang.Math;

class FractionToRecurringDecimal {
    public static void main(String[] args) {
      System.out.println(fractionToDecimal(1, 99));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        if(numerator < 0 ^ denominator < 0) sb.append("-");
        long l_numerator = Math.abs((long) numerator);
        long l_denominator = Math.abs((long) denominator);

        String result = "" + l_numerator/l_denominator;
        l_numerator %= l_denominator;
        sb.append(result);

        if(l_numerator == 0) return sb.toString();

        sb.append(".");

        while(!map.containsKey(l_numerator)) {
            map.put(l_numerator, sb.length());
            sb.append(l_numerator * 10 / l_denominator);
            l_numerator = l_numerator * 10 % l_denominator;
        }

        sb.insert(map.get(l_numerator), "(");
        sb.append(")");

        return sb.toString().replace("(0)", "");
    }
}
