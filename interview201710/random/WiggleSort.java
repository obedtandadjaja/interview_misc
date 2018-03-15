/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.
*/

import java.util.*;

class WiggleSort {
    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,1,2,1,1,2,2,1 };
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[nums.length];
        
        int index = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(index >= nums.length) index = 0;
            result[index] = nums[i];
            index += 2;
        }
        
        for(int i = 0; i < result.length; i++) {
            nums[i] = result[i];
        }
    }
}
