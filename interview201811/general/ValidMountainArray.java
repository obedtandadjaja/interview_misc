/*
	Difficulty: Easy
	Runtime: 5 ms, faster than 62.50% of Java online submissions for Valid Mountain Array.

	Given an array A of integers, return true if and only if it is a valid mountain array.

	Recall that A is a mountain array if and only if:

	A.length >= 3
	There exists some i with 0 < i < A.length - 1 such that:
	A[0] < A[1] < ... A[i-1] < A[i]
	A[i] > A[i+1] > ... > A[B.length - 1]

	Example 1:

	Input: [2,1]
	Output: false

	Example 2:

	Input: [3,5,5]
	Output: false

	Example 3:

	Input: [0,3,2,1]
	Output: true

	Note:
	0 <= A.length <= 10000
	0 <= A[i] <= 10000 
 */

class ValidMountainArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 3, 2, 1 };
		validMountainArray(arr);
	}

  public static boolean validMountainArray(int[] A) {
    if(A.length < 3) return false;
    if(A[0] > A[1] || A[A.length-2] < A[A.length-1]) return false;

    int i = 0;
    while(i < A.length-1 && A[i] < A[i+1]) i++;
    while(i < A.length-1 && A[i] > A[i+1]) i++;

    return i == A.length-1;
  }
}
