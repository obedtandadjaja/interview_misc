package DataStructures.iterators;

import DataStructures.abstracts.TreeTraversalIterator;
import DataStructures.BSTNode;

import java.util.*;

public class InOrderTraversalIterator<E> extends TreeTraversalIterator<E> {

  public InOrderTraversalIterator(BSTNode<E> root) {
    this.nextNode = root;
    if(this.nextNode != null) {
      while(this.nextNode.left != null) this.nextNode = this.nextNode.left;
    }
  }

  public boolean hasNext() {
    return this.nextNode != null;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();

    BSTNode<E> current = this.nextNode;

    if(this.nextNode.right != null) {
      this.nextNode = this.nextNode.right;
      while(this.nextNode.left != null) this.nextNode = this.nextNode.left;
      return current.data;
    } else {
      while(true) {
        if(this.nextNode.parent == null) {
          this.nextNode = null;
          return current.data;
        } else if(this.nextNode.parent.left == this.nextNode) {
          this.nextNode = this.nextNode.parent;
          return current.data;
        }
        this.nextNode = this.nextNode.parent;
      }
    }
  }

}
