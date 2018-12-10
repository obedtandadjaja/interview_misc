/*
	Difficulty: Easy
	Runtime: 9 ms, faster than 46.58% of Java online submissions for Symmetric Tree.

	Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

	For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
	     1
	   /  \
    2   2
	 / \ / \
	3  4 4  3

	But the following [1,2,2,null,3,null,3] is not:
	    1
	   / \
    2   2
	  \   \
	  3    3
	Note:
	Bonus points if you could solve it both recursively and iteratively.
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

class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    if(root == null) return true;

    return areRootsSymmetric(root.left, root.right);
  }

  public boolean areRootsSymmetric(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null || root2 == null) return false;

    return root1.val == root2.val &&
      areRootsSymmetric(root1.left, root2.right) &&
      areRootsSymmetric(root1.right, root2.left);
  }

	// iterative solution
	public boolean isSymmetric2(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if (t1 == null && t2 == null) continue;
			if (t1 == null || t2 == null) return false;
			if (t1.val != t2.val) return false;
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
    }
    return true;
	}
}
