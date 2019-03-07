/*
  Difficulty: Medium

  Shuffle a set of numbers without duplicates.

  Example:

  // Init an array with set 1, 2, and 3.
  int[] nums = {1,2,3};
  Solution solution = new Solution(nums);

  // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
  solution.shuffle();

  // Resets the array back to its original configuration [1,2,3].
  solution.reset();

  // Returns the random shuffling of array [1,2,3].
  solution.shuffle();
 */

// Idea is to pick a number out of a hat...
// Once you pick a number, you cannot repick it
// So we do random for an index and random anything from index + 1 to length

class Solution {
  int[] original;

  public Solution(int[] nums) {
    this.original = nums;
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    return this.original;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] shuffled = this.original.clone();

    Random rand = new Random();

    for(int i = 0; i < shuffled.length; i++) {
      int swapIndex = rand.nextInt(shuffled.length - i) + i;

      int temp = shuffled[i];
      shuffled[i] = shuffled[swapIndex];
      shuffled[swapIndex] = temp;
    }

    return shuffled;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
