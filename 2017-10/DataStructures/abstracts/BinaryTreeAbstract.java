package DataStructures.abstracts;

import DataStructures.BSTNode;
import DataStructures.iterators.InOrderTraversalIterator;

import DataStructures.interfaces.Tree;

import java.util.*;

public abstract class BinaryTreeAbstract<E extends Comparable<E>> implements Tree<E>, Iterable<E> {
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

  public Iterator<E> iterator() {
    return new InOrderTraversalIterator(this.root);
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    for(E data : this) {
      str.append(data);
      str.append(", ");
    }
    return str.toString();
  }
}
