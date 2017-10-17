package DataStructures.iterators;

import DataStructures.abstracts.TreeTraversalIterator;
import DataStructures.BSTNode;

import DataStructures.Queue;

import java.util.*;

public class BFSIteratorBST<E> extends TreeTraversalIterator<E> {

  Queue<BSTNode<E>> q;

  public BFSIteratorBST(BSTNode<E> root) {
    this.nextNode = root;
    this.q = new Queue<BSTNode<E>>();
  }

  public boolean hasNext() {
    return this.nextNode != null;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();

    E returnValue = this.nextNode.data;

    if(this.nextNode.left != null) this.q.add(this.nextNode.left);
    if(this.nextNode.right != null) this.q.add(this.nextNode.right);

    this.nextNode = this.q.poll();

    return returnValue;
  }

}
