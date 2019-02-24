/*
  Difficulty: Easy

  Given a binary tree, return all root-to-leaf paths.

  Note: A leaf is a node with no children.

  Example:

  Input:

  1
  /   \
  2     3
  \
  5

  Output: ["1->2->5", "1->3"]

  Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();

    if(root == null) return result;

    DFS(result, root, "");

    return result;
  }

  public void DFS(List<String> result, TreeNode root, String curr) {
    if(root.left == null && root.right == null) {
      result.add(curr + root.val);
      return;
    }

    if(root.left != null) DFS(result, root.left, curr + root.val + "->");
    if(root.right != null) DFS(result, root.right, curr+ root.val + "->");
  }
}
