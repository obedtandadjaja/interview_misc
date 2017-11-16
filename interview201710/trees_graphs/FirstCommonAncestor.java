package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class FirstCommonAncestor {
  public static void main(String[] args) {
    BinaryTree<Integer> bst = new BinaryTree<>();
    bst.add(5);
    bst.add(3);
    bst.add(7);
    bst.add(2);
    bst.add(4);
    bst.add(8);
    bst.add(6);

    System.out.println(getFirstCommonAncestorWithoutParent(bst.root, bst.root.left.left, bst.root.right.right).data);
  }

  public static BSTNode<Integer> getFirstCommonAncestor(BSTNode<Integer> n1, BSTNode<Integer> n2) {
    int height1 = getNodeHeight(n1);
    int height2 = getNodeHeight(n2);

    if(height1 < height2) {
      for(int i = 0; i < height2 - height1; i++)
        n2 = n2.parent;
    } else if (height2 < height1) {
      for(int i = 0; i < height1 - height2; i++)
        n1 = n1.parent;
    }

    while(n1 != n2) {
      n1 = n1.parent;
      n2 = n2.parent;
    }

    return n1;
  }

  public static int getNodeHeight(BSTNode<Integer> n) {
    int height = 0;
    while(n != null) {
      height++;
      n = n.parent;
    }
    return height;
  }

  public static BSTNode<Integer> getFirstCommonAncestorWithoutParent
    (BSTNode<Integer> root, BSTNode<Integer> n1, BSTNode<Integer> n2) {
    if(root == null) {
      return null;
    }
    if(root == n1 && root == n2) {
      System.out.println(root.data);
      return root;
    }

    BSTNode<Integer> x = getFirstCommonAncestorWithoutParent(root.left, n1, n2);
    if(x != null && x != n1 && x != n2) return x;

    BSTNode<Integer> y = getFirstCommonAncestorWithoutParent(root.right, n1, n2);
    if(y != null && y != n1 && y != n2) return y;

    if(x != null && y != null) {
      return root;
    } else if(root == n1 || root == n2) {
      return root;
    } else {
      return x == null ? y : x;
    }
  }
}
