/*
 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w 
as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, 
since a node can be a descendant of itself according to the LCA definition.
*/

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // recursion and backtracking
        if(root == null || root == p || root == q) return root;
        
        // search left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        if(left != null && left != p && left != q) return left;
        
        // search right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(right != null && right != p && right != q) return right;
        
        if(left != null && right != null) return root;
        return left != null ? left : right;
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // find paths to each node
        List<TreeNode> p1 = findPath(root, new ArrayList<TreeNode>(), p);
        List<TreeNode> p2 = findPath(root, new ArrayList<TreeNode>(), q);
        
        // get the diverging point
        for(int i = 0; i < p1.size() && i < p2.size(); i++) {
            if(p1.get(i) != p2.get(i)) {
                return p1.get(i-1);
            }
        }
        
        return p1.size() > p2.size() ? p2.get(p2.size()-1) : p1.get(p1.size()-1);
    }
    
    public List<TreeNode> findPath(TreeNode root, List<TreeNode> l, TreeNode x) {
        if(root == null) return null;
        else {            
            l.add(root);
            if(root == x) return l;
            
            List<TreeNode> left = findPath(root.left, l, x);
            if(left != null) return l;
            
            List<TreeNode> right = findPath(root.right, l, x);
            if(right != null) return l;
            
            l.remove(l.size()-1);
            return null;
        }
    }
}
