/*
  Difficulty: Easy

  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

  For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

  Example:

  Given the sorted array: [-10,-3,0,5,9],

  One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

  0
  / \
  -3   9
  /   /
  -10  5
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SortedArrayToBST {
  public TreeNode sortedArrayToBST(int[] nums) {
    return generateBST(nums, 0, nums.length - 1);
  }

  public TreeNode generateBST(int[] nums, int start, int end) {
    if(start > end) return null;

    int mid = (start + end) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = generateBST(nums, start, mid - 1);
    root.right = generateBST(nums, mid + 1, end);

    return root;
  }
}
