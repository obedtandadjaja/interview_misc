package DataStructures.abstracts;

import DataStructures.BSTNode;
import DataStructures.iterators.InOrderTraversalIterator;

import java.util.*;

public abstract class BinaryTreeAbstract<E extends Comparable<E>> implements Iterable<BSTNode> {
  protected int size;
  public BSTNode<E> root;

  public BinaryTreeAbstract() {
    this.size = 0;
    this.root = null;
  }
  public abstract void add(E data);
  public abstract void delete(E data);
  public abstract boolean lookup(E data);

  public int size() {
    return this.size;
  }

  public Iterator<BSTNode> iterator() {
    return new InOrderTraversalIterator(this.root);
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    for(BSTNode n : this) {
      str.append(n.data);
      str.append(", ");
    }
    return str.toString();
  }
}
