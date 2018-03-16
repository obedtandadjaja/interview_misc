/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */

import java.util.*;

class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[] { 121, 12 };
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        String[] numbers = new String[nums.length];
        for(int i = 0; i < nums.length; i++) numbers[i] = String.valueOf(nums[i]);

        Comparator<String> comp = new Comparator<String>(){
        @Override
        public int compare(String str1, String str2){
            String s1 = str1 + str2;
          String s2 = str2 + str1;
          return s1.compareTo(s2);
        }
        };

        Arrays.sort(numbers, comp);

        StringBuilder sb = new StringBuilder();
        for(int i = numbers.length-1; i >= 0; i--) {
            sb.append(numbers[i]);
        }

        if(sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
