// Given two strings s1 and s2(call letters in uppercase).
// Check if it is possible to convert s1 to s2 by performing following operations:
// 1. Make some lowercase letters uppercase.
// 2. Delete all the lowercase letters.
//
// Input : s1 = daBcd s2 = ABC
// Output : yes
// Explanation : daBcd -> dABCd -> ABC
// Covert a and b at index 1 and 3 to
// upper case, delete the rest those are
// lowercase. We get the string s2.

// Input : s1 = argaju    s2 = RAJ
// Output : yes
// Explanation : argaju -> aRgAJu -> RAJ
// convert index 1, 3 and 4 to uppercase
// and then delete. All lowercase letters

// Input : s1 = ABcd s2= BCD
// Output : NO

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class StringTransformation {
  public static void main (String[] args) {
    String s1 = "ABcd";
    String s2 = "BCD";

    System.out.println(isTransformable(s1, s2));
  }

  public static boolean isTransformable(String s1, String s2) {
      int[] cache = new int[52];
    int upperCaseCnt = 0;

      // loop through s1 and gather info
    for(int i = 0; i < s1.length(); i++) {
        char a = s1.charAt(i);
        int ascii = (int) a;

        if(ascii >= 65 && ascii <= 90) {
            cache[ascii-65]++;
            upperCaseCnt++;
        } else if(ascii >= 97 && ascii <= 122) {
            cache[ascii-97+26]++;
        } else {
            // String contains non-alphabetic character
            return false;
        }
    }

    // loop through s2
    for(int i = 0; i < s2.length(); i++) {
        char a = s2.charAt(i);
        int ascii = (int) a;

        if(cache[ascii-65] > 0) {
            cache[ascii-65]--;
            upperCaseCnt--;
        } else if(cache[ascii-65+26] > 0) {
            cache[ascii-65+26]--;
        } else {
            return false;
        }
    }

    if(upperCaseCnt == 0) return true;

    return false;
  }
}
