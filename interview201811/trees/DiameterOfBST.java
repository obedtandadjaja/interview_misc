/*
  Difficulty: Easy

  Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

  Example:
  Given a binary tree
  1
  / \
  2   3
  / \
  4   5
  Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

  Note: The length of path between two nodes is represented by the number of edges between them.
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
class DiameterOfBST {
  public int diameterOfBinaryTree(TreeNode root) {
    if(root == null) return 0;

    return getChildPaths(root)[1];
  }

  public int[] getChildPaths(TreeNode root) {
    if(root == null) return new int[] { 0, 0 };

    int[] left = getChildPaths(root.left);
    int[] right = getChildPaths(root.right);
    int max_path = Math.max(Math.max(left[1], left[0] + right[0]), right[1]);

    return new int[] { 1 + Math.max(left[0], right[0]), max_path  };
  }
}
