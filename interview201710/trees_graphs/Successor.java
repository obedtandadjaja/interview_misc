package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class Successor {
  public static void main(String[] args) {
    BinaryTree<Integer> bst = new BinaryTree<>();
    bst.add(5);
    bst.add(3);
    bst.add(7);
    bst.add(2);
    bst.add(4);
    bst.add(8);
    bst.add(6);
    System.out.println("5 -> " + nextInorderSuccessor(bst.root).data);
    System.out.println("3 -> " + nextInorderSuccessor(bst.root.left).data);
    System.out.println("7 -> " + nextInorderSuccessor(bst.root.right).data);
    System.out.println("2 -> " + nextInorderSuccessor(bst.root.left.left).data);
    System.out.println("4 -> " + nextInorderSuccessor(bst.root.left.right).data);
    System.out.println("8 -> " + nextInorderSuccessor(bst.root.right.right));
    System.out.println("6 -> " + nextInorderSuccessor(bst.root.right.left).data);
  }

  public static BSTNode<Integer> nextInorderSuccessor(BSTNode<Integer> n) {
    if(n == null) return null;

    if(n.right != null) {
      n = n.right;
      while(n.left != null) n = n.left;
      return n;
    } else {
      while(true) {
        if(n.parent == null) return null;
        if(n.parent.left == n) return n.parent;
        n = n.parent;
      }
    }
  }
}
