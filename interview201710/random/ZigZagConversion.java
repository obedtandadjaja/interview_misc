/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/

import java.util.*;

class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(convert(s, numRows));
    }

    public static String convert(String s, int numRows) {
        if(s.length() <= 1 || numRows <= 1) return s;
        
        StringBuilder sb = new StringBuilder();
        int interval = (numRows - 1) * 2;
        
        for(int i = 0; i < numRows; i++) {
            int index = i;
            int count = 0;
            while(index < s.length()) {
                sb.append(s.charAt(index));
                count++;
                index += ((count > 0 && count % 2 == 0 && i > 0) || interval == 0) ? i * 2 : interval;
            }
            interval -= 2;
        }
        
        return sb.toString();
    }
}
