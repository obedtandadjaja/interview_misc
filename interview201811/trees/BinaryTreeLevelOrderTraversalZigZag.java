/*
  Difficulty: Medium

  Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

  For example:
  Given binary tree [3,9,20,null,null,15,7],
  3
  / \
  9  20
  /  \
  15   7
  return its zigzag level order traversal as:
  [
  [3],
  [20,9],
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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> levelList = new LinkedList<>();
    int count = 0;

    if(root == null) return result;

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      levelList.clear();

      int size = q.size();
      for(int i = 0; i < size; i++) {
        TreeNode currNode = q.poll();

        if(count % 2 == 0)
          levelList.addLast(currNode.val);
        else
          levelList.addFirst(currNode.val);

        if(currNode.left != null) q.offer(currNode.left);
        if(currNode.right != null) q.offer(currNode.right);
      }

      result.add(new ArrayList<>(levelList));
      count++;
    }

    return result;
  }
}
