/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[] { 7,8,9,1,2,3,4,5,6 };
        int target = 5;
        System.out.println(search(nums, target));
    }

    public int search(int[] nums, int target) {
        
        // finding starting index
        int starting_index = 0;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                starting_index = i+1;
                break;
            }
        }
        
        // binary search
        int start = 0;
        int end = nums.length-1;
        int middle = (start + end)/2;
        
        while(start <= end) {
            int current = (middle + starting_index) % nums.length;
            
            if(nums[current] > target) end = middle-1;
            else if(nums[current] < target) start = middle+1;
            else return current;
            
            middle = (start + end)/2;
        }
        
        return -1;
    }
}
