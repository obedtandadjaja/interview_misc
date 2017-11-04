import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer> data = new ArrayList<>();
        for(int a_i=0; a_i < n; a_i++){
            int a = in.nextInt();
            int pos = Collections.binarySearch(data, a);
            System.out.println(pos);
            if (pos < 0) pos = Math.abs(pos)-1;
            data.add(pos, a);
            System.out.println(median(data));
        }
    }

    public static double median(List<Integer> data) {
      if ((data.size() & 1) == 1) {
        return (double) data.get(data.size()/2);
      } else {
        int midSize = data.size()/2;
        return (data.get(midSize-1) + data.get(midSize)) / 2.0;
      }
    }
}