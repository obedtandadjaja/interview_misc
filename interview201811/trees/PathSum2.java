/*
  Difficulty: Medium

  Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

  Note: A leaf is a node with no children.

  Example:

  Given the below binary tree and sum = 22,

  5
  / \
  4   8
  /   / \
  11  13  4
  /  \    / \
  7    2  5   1
  Return:

  [
  [5,4,11,2],
  [5,8,4,5]
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
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();

    LinkedList<Integer> currList = new LinkedList<>();
    DFS(result, sum, root, currList);

    return result;
  }

  public void DFS(List<List<Integer>> result, int target, TreeNode root, LinkedList<Integer> currList) {
    if(root == null) return;
    if(root.left == null && root.right == null && target == root.val) {
      currList.addLast(root.val);
      result.add(new ArrayList<Integer>(currList));
      currList.removeLast();
      return;
    }

    currList.addLast(root.val);
    DFS(result, target - root.val, root.left, currList);
    DFS(result, target - root.val, root.right, currList);
    currList.removeLast();
  }
}
