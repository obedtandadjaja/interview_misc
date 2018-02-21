/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
*/

import java.util.*;

class IntegerToRoman {
    public static void main(String[] args) {
        int num = 3999;
        System.out.println(intToRoman(num));
    }
    
    public static String intToRoman(int num) {
        String[] romans = new String[] { "M", "D", "C", "L", "X", "V", "I" };
        int[] values = new int[] { 1000, 500, 100, 50, 10, 5, 1 };
        
        int multiplier = 1;
        StringBuilder sb = new StringBuilder();
        
        while(num > 0) {
            int numeric = num % 10;
            num /= 10;
            int value = numeric * multiplier;
            
            int index = 0;
            while(index < romans.length && values[index] > value) index++;
            
            if(numeric == 4) {
                sb.insert(0, romans[index-1]);
                sb.insert(0, romans[index]);
            } else if(numeric == 9) {
                sb.insert(0, romans[index-1]);
                sb.insert(0, romans[index+1]);
            } else {
                String temp = "";
                while(value > 0) {
                    if(values[index] > value) index++;
                    temp += romans[index];
                    value -= values[index];
                }
                sb.insert(0, temp);
            }
            
            multiplier *= 10;
        }
        
        return sb.toString();
    }
}
