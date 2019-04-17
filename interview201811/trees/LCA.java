/*
  Difficulty: Medium

  Find the lowest common ancestor in an unordered binary tree given two values in the tree.

  Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
  Example :


  _______3______
  /              \
  ___5__          ___1__
  /      \        /      \
  6      _2_     0        8
  /   \
  7    4
  For the above tree, the LCA of nodes 5 and 1 is 3.

  LCA = Lowest common ancestor
  Please note that LCA for nodes 5 and 4 is 5.

  You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
  No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
  There are no duplicate values.
  You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
*/

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
  public int lca(TreeNode A, int B, int C) {
    if(A == null) return -1;

    Result result = helper(A, B, C);
    if(result != null && result.found) {
      return result.val;
    } else {
      return -1;
    }
  }

  public Result helper(TreeNode A, int B, int C) {
    if(A == null) return null;
    if(A.val == B && A.val == C) return new Result(A.val, true); // if A.val == B == C then return A.val

    // search left and right, if both already found then just bubble up the answer right away
    // if B or C is found, check current val if it matches the other, if yes then bubble up answer
    Result left = helper(A.left, B, C);
    if(left != null) {
      if(left.found) return left;
      if(A.val == B || A.val == C) return new Result(A.val, true);
    }

    Result right = helper(A.right, B, C);
    if(right != null) {
      if(right.found) return right;
      if(A.val == B || A.val == C) return new Result(A.val, true);
    }

    // when right and left is not null then current is the LCA
    if(right != null && left != null) return new Result(A.val, true);

    // when current is B or C
    if(A.val == B || A.val == C) return new Result(A.val, false);

    return left != null ? left : right;
  }

  // need to keep track of found - to determine if the answer is complete yet
  class Result {
    int val;
    boolean found;

    public Result(int val, boolean found) {
      this.val = val;
      this.found = found;
    }
  }
}
