/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

import java.util.*;

class NextPermutation {
    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,3 };
        System.out.println(Arrays.toString(nextPermutation(nums)));
    }

    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        
        int index = nums.length - 2;
        while(index >= 0 && nums[index] >= nums[index+1]) index--;
        
        if(index >= 0) {
            int index2 = nums.length - 1;
            while(nums[index] >= nums[index2]) index2--;
            swap(nums, index, index2);
        }
        
        reverse(nums, index+1, nums.length-1);
    }
    
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end)
            swap(nums, start++, end--);
    }
}
