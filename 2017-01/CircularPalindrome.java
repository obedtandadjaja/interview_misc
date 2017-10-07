import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/circular-palindromes
 * Basically search for the largest palindrome in every left shift
 */

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String string = in.next();
        calculate(length, string);
    }

    public static void calculate(int length, String str) {
        System.out.println(searchPalindromes(str));
        for(int i = 0; i < length-1; i++) {
            String new_string = str.substring(1,str.length())+str.charAt(0);
            str = new_string;
            System.out.println(searchPalindromes(str));
        }
    }

    public static int searchPalindromes(String str) {
        int longestLength = 0;
        int length = str.length();
        for(int j = 0; j < length; j++) {
            for(int k = length; k >= j; k--) {
                String s = str.substring(j, k);
                int sub_length = s.length();
                if(s.length() <= longestLength) break;
                int middle = sub_length/2;
                if(s.length() == 1) {
                    longestLength = sub_length;
                } else if(s.length()%2 == 0) {
                    if(s.substring(0,middle).equals(reverseString(s.substring(middle,sub_length))))
                        longestLength = sub_length;
                } else {
                    if(s.substring(0,middle).equals(reverseString(s.substring(middle+1,sub_length))))
                        longestLength = sub_length;
                }
            }
        }
        return longestLength;
    }

    public static String reverseString(String str) {
        String reverse = "";
        for(int i = str.length()-1; i >= 0; i--) {
            reverse += str.charAt(i);
        }
        return reverse;
    }
}