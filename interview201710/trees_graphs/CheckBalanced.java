package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class CheckBalanced {
  public static void main(String[] args) {
    BinaryTree<Integer> balanced = new BinaryTree<>();
    balanced.add(5);
    balanced.add(3);
    balanced.add(7);
    balanced.add(2);
    balanced.add(4);
    balanced.add(8);
    balanced.add(6);
    System.out.println(isBalanced(balanced.root) > 0 ? "balanced" : "unbalanced");

    BinaryTree<Integer> unbalanced = new BinaryTree<>();
    unbalanced.add(5);
    unbalanced.add(3);
    unbalanced.add(2);
    unbalanced.add(4);
    unbalanced.add(7);
    unbalanced.add(8);
    System.out.println(isBalanced(unbalanced.root) > 0 ? "balanced" : "unbalanced");
  }

  public static int isBalanced(BSTNode<Integer> root) {
    if(root == null) return 0;
    if((root.left != null || root.right != null) && (root.left == null || root.right == null)) return -1;
    int left = isBalanced(root.left) + 1;
    int right = isBalanced(root.right) + 1;
    return ((left != right) || (left == -1 || right == -1)) ? -1 : left;
  }
}
