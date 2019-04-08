/*
  Difficulty: Medium

  Given a binary tree, flatten it to a linked list in-place.

  For example, given the following tree:

  1
  / \
  2   5
  / \   \
  3   4   6
  The flattened tree should look like:

  1
  \
  2
  \
  3
  \
  4
  \
  5
  \
  6
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
class Solution {
  public void flatten(TreeNode root) {
    if(root == null) return;

    flatten(root.left);
    flatten(root.right);

    TreeNode left = root.left;
    TreeNode right = root.right;

    if(left != null) {
      root.right = left;
      root.left = null;

      while(left.right != null) {
        left = left.right;
      }

      left.right = right;
    }
  }
}
