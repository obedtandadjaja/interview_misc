/*
  Difficulty: Easy

  Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
  Example 1:
  Input:
  3
  / \
  9  20
  /  \
  15   7
  Output: [3, 14.5, 11]
  Explanation:
  The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
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
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      double sum = 0.0;
      int count = q.size();

      for(int i = 0; i < count; i++) {
        TreeNode curr = q.poll();
        sum += curr.val;
        if(curr.left != null) q.add(curr.left);
        if(curr.right != null) q.add(curr.right);
      }

      result.add(sum / count);
    }

    return result;
  }
}
