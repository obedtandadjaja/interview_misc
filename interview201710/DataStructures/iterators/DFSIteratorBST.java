package interview201710.DataStructures.iterators;

import interview201710.DataStructures.abstracts.TreeTraversalIterator;
import interview201710.DataStructures.BSTNode;

import interview201710.DataStructures.Stack;

import java.util.*;

public class DFSIteratorBST<E> extends TreeTraversalIterator<E> {

  Stack<BSTNode<E>> s;

  public DFSIteratorBST(BSTNode<E> root) {
    this.nextNode = root;
    this.s = new Stack<BSTNode<E>>();
  }

  public boolean hasNext() {
    return this.nextNode != null;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();

    E returnValue = this.nextNode.data;

    if(this.nextNode.right != null) this.s.push(this.nextNode.right);
    if(this.nextNode.left != null) this.s.push(this.nextNode.left);

    this.nextNode = this.s.pop();

    return returnValue;
  }

}
