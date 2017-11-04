package interview201710.DataStructures.iterators;

import interview201710.DataStructures.abstracts.TreeTraversalIterator;
import interview201710.DataStructures.BSTNode;

import interview201710.DataStructures.Queue;

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
