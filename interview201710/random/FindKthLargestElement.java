// Find the kth largest element in an unsorted array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.

public class findKthLargestElement {

    public static void main(String[] args) {
        int[] nums = new int[] {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            if(max < num) max = num;
            if(min > num) min = num;
        }

        int[] frequency = new int[max-min+1];

        for(int num : nums) {
            frequency[max-num]++;
        }

        for(int i = 0; i < frequency.length; i++) {
            k -= frequency[i];
            if(k <= 0) return max-i;
        }

        return -1;

    }

}
