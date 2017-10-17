package DataStructures.abstracts;

import DataStructures.TreeNode;

import DataStructures.interfaces.Tree;
import DataStructures.interfaces.Searchable;
import DataStructures.interfaces.Searcher;

public abstract class TreeAbstract<E> implements Tree<E>, Searchable<E> {
  protected int size;
  public TreeNode<E> root;

  public TreeAbstract() {
    this.size = 0;
    this.root = null;
  }

  public abstract void add(E data);
  public abstract void delete(E data);

  public int size() {
    return this.size;
  }

  public Searcher<E> searcher() {
    // return new DFSSearcher(this.root);
    return null;
  }

  public String toString() {
    // StringBuilder str = new StringBuilder();
    // for(E data : this) {
    //   str.append(data);
    //   str.append(", ");
    // }
    // return str.toString();
    return "this is a tree";
  }
}
