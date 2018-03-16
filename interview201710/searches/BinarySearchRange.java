/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
*/

class BinarySearchRange {
    public static void main(String[] args) {
        int[] nums = new int[] { 1,2,3,3,3,4,5,5,5,5,6 };
        int target = 5;
        int[] results = searchRange(nums, target);
        System.out.println(results[0] + ", " + results[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        
        // binary search
        int start = 0; int end = nums.length-1;
        int middle = (start+end)/2;
        int index = -1;
        
        while(start <= end) {
            if(nums[middle] < target) start = middle+1;
            else if(nums[middle] > target) end = middle-1;
            else {
                index = middle;
                break;
            }
            
            middle = (start+end)/2;
        }
        
        // find both ways
        if(index != -1) {
            int range_start = 0;
            int range_end = nums.length-1;
            
            for(int i = index-1; i >= 0; i--) {
                if(nums[i] != target) {
                    range_start = i+1;
                    break;
                }
            }
            
            for(int i = index+1; i < nums.length; i++) {
                if(nums[i] != target) {
                    range_end = i-1;
                    break;
                }
            }
            
            return new int[] { range_start, range_end };
        } else {
            return new int[] { -1, -1 };
        }
    }
}
