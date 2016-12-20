import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * We delete the following characters from our two strings to turn them into anagrams of each other:
    Remove d and e from cde to get c.
    Remove a and b from abc to get c.
    We must delete  characters to make both strings anagrams, so we print 4 on a new line.
 */

public class Solution {
    public static int numberNeeded(String first, String second) {
        int[] freq = new int[26];
        first.chars().forEach((c) -> {
            freq[c - 97]++;
        });
        second.chars().forEach((c) -> {
            freq[c - 97]--;
        });
        return Arrays.stream(freq).map(Math::abs).sum();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
