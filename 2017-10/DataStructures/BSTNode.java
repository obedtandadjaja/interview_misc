package DataStructures;

import DataStructures.abstracts.NodeAbstract;

public class BSTNode<E> extends NodeAbstract<E> {
  public BSTNode left;
  public BSTNode right;
  public BSTNode parent;

  public BSTNode(BSTNode left, E data, BSTNode right) {
    this.left = left;
    this.data = data;
    this.right = right;
    this.parent = null;
  }

  public BSTNode(BSTNode left, E data, BSTNode right, BSTNode parent) {
    this.left = left;
    this.data = data;
    this.right = right;
    this.parent = parent;
  }
}
