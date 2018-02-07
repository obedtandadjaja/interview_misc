// Maximum subarray sum in an array created after repeated concatenation
// Given an array and a number k, find the largest sum of contiguous array in
// the modified array which is formed by repeating the given array k times.
//
// Input  : arr[] = {-1, 10, 20}, k = 2
// Output : 59
// After concatenating array twice, we
// get {-1, 10, 20, -1, 10, 20} which has
// maximum subarray sum as 59.

// Input  : arr[] = {-1, -2, -3}, k = 3
// Output : -1

public class MaxSubarraySumRepeatedConcat {

  public static void main(String[] args) {
    int k = 3;
    int[] array = new int[] { 25, -25, 12, -10, 50 };

    System.out.println(getMaximumSubarray(array, k));
  }

  public static int getMaximumSubarray(int[] array, int k) {
    int max = Integer.MIN_VALUE;
    int currentMax = 0;

    for(int i = 0; i < array.length * k; i++) {
        currentMax += array[i % array.length];
        if(currentMax > max) max = currentMax;
        if(currentMax < 0) currentMax = 0;
    }

    return max;
  }

}
