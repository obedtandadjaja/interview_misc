/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

class 3Sum {
    public static void main(String[] args) {
        int[] nums = new int[] { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = threeSum(nums);
        for(List<Integer> l : list) System.out.println(l.toString());
    }
  
    public static List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int start = i + 1; 
            int end = nums.length - 1;
            
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < 0) start++;
                else if(sum > 0) end--;
                else {
                    ArrayList<Integer> array = new ArrayList<>();
                    array.add(nums[i]);
                    array.add(nums[start]);
                    array.add(nums[end]);
                    list.add(array);
                    
                    while(start + 1 < end && nums[start] == nums[start+1]) start++;
                    while(end - 1 > start && nums[end] == nums[end-1]) end--;
                    
                    start++;
                    end--;
                }
            }
        }
        
        return list;
    }
}
