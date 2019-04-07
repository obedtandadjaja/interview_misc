/*
  Difficulty: Medium

  Given a binary tree, return the inorder traversal of its nodes' values.

  Example:

  Input: [1,null,2,3]
  1
  \
  2
  /
  3

  Output: [1,3,2]
  Follow up: Recursive solution is trivial, could you do it iteratively?
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
  // 1: use stack and another loop to iterate to left most tree always
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if(root == null) return result;

    Stack<TreeNode> stack = new Stack<>();

    TreeNode curr = root;
    while(curr != null || !stack.isEmpty()) {
      // iterate to left most tree node
      while(curr != null) {
        stack.push(curr);
        curr = curr.left;
      }

      curr = stack.pop();
      result.add(curr.val);

      // iterate to the right afterwards
      curr = curr.right;
    }

    return result;
  }

  // 2: use stack and hashset
  public List<Integer> inorderTraversal2(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    if(root == null) return result;

    Set<TreeNode> visited = new HashSet<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while(!stack.isEmpty()) {
      TreeNode curr = stack.pop();

      if(curr.left != null && !visited.contains(curr.left)) {
        // put curr back to the stack before left to get evaluated later
        stack.push(curr);

        stack.push(curr.left);
        visited.add(curr.left);

        continue;
      }

      // will only add the value once left has been visited
      result.add(curr.val);

      if(curr.right != null && !visited.contains(curr.right)) {
        stack.push(curr.right);
        visited.add(curr.right);
      }
    }

    return result;
  }
}
