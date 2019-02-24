/*
  Difficulty: Medium

  Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
  3
  / \
  9  20
  /  \
  15   7
  return its level order traversal as:
  [
  [3],
  [9,20],
  [15,7]
  ]
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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if(root == null) return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      List<Integer> currTraversal = new ArrayList<>();
      int count = q.size();

      for(int i = 0; i < count; i++) {
        TreeNode curr = q.poll();
        currTraversal.add(curr.val);

        if(curr.left != null) q.add(curr.left);
        if(curr.right != null) q.add(curr.right);
      }

      result.add(currTraversal);
    }

    return result;
  }
}
