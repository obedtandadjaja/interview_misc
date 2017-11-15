package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class ValidateBST {
  public static void main(String[] args) {
    BinaryTree<Integer> bst = new BinaryTree<>();
    bst.add(5);
    bst.add(3);
    bst.add(7);
    bst.add(2);
    bst.add(4);
    bst.add(8);
    bst.add(6);
    System.out.println(isBST(Integer.MIN_VALUE, bst.root, Integer.MAX_VALUE));

    BinaryTree<Integer> nonbst = new BinaryTree<>();
    nonbst.add(5);
    nonbst.add(3);
    nonbst.add(2);
    nonbst.add(4);
    nonbst.add(7);
    nonbst.add(8);
    nonbst.root.right.right.data = 5;
    System.out.println(isBST(Integer.MIN_VALUE, nonbst.root, Integer.MAX_VALUE));
  }

  public static boolean isBST(int min, BSTNode<Integer> root, int max) {
    if(root == null) return true;
    if(min > root.data || max < root.data) return false;
    else return isBST(min, root.left, root.data) && isBST(root.data, root.right, max);
  }
}
