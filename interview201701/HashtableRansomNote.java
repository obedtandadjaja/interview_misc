import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(check(magazine, ransom) ? "Yes" : "No");
    }

    public static boolean check(String[] m, String[] r) {
        Hashtable<String, Integer> hash = setHashtable(m);
        for(int i = 0; i < r.length; i++) {
            if(hash.containsKey(r[i]) && hash.get(r[i]) > 0) hash.put(r[i], hash.get(r[i])-1);
            else return false;
        }
        return true;
    }

    public static Hashtable<String,Integer> setHashtable(String[] m) {
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        for(int i = 0; i < m.length; i++) {
            if(hash.containsKey(m[i])) hash.put(m[i], hash.get(m[i])+1);
            else hash.put(m[i], 1);
        }
        return hash;
    }
}
