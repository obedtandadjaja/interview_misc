/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */

class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if(k > length) k %= nums.length;

        int startPoint = 0;
        while(startPoint + k < nums.length && k != 0) {

            for(int i = 0; i < k; i++) {
                int temp = nums[startPoint + i];
                nums[startPoint + i] = nums[nums.length-k+i];
                nums[nums.length-k+i] = temp;
            }

            startPoint += k;
            length -= k;
            if(k > length) k %= length;
        }
    }
}
