/*
  Difficulty: Medium

  Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

  Example:

  Input: 3
  Output:
  [
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
  ]
  Explanation:
  The above output corresponds to the 5 unique BST's shown below:

  1         3     3      2      1
  \       /     /      / \      \
  3     2     1      1   3      2
  /     /       \                 \
  2     1         2                 3
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
  public List<TreeNode> generateTrees(int n) {
    if(n == 0) return new ArrayList<TreeNode>();

    return generateSubtrees(1, n);
  }

  // idea here is to pick a root,
  // and have the numbers lower than it to be in the left tree
  // and numbers higher than it to be in the right tree.
  // Create the children first and construct the parent afterwards
  public List<TreeNode> generateSubtrees(int start, int end) {
    List<TreeNode> all_trees = new ArrayList<TreeNode>();

    if(start > end) {
      all_trees.add(null);
      return all_trees;
    }

    for(int i = start; i <= end; i++) {
      List<TreeNode> left_trees = generateSubtrees(start, i - 1);
      List<TreeNode> right_trees = generateSubtrees(i + 1, end);

      for(TreeNode l : left_trees) {
        for(TreeNode r : right_trees) {
          TreeNode current = new TreeNode(i);
          current.left = l;
          current.right = r;
          all_trees.add(current);
        }
      }
    }

    return all_trees;
  }
}
