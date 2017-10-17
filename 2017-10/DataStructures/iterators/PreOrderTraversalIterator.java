package DataStructures.iterators;

import DataStructures.abstracts.TreeTraversalIterator;
import DataStructures.BSTNode;
import DataStructures.Stack;

import java.util.*;

public class PreOrderTraversalIterator<E extends Comparable<E>> extends TreeTraversalIterator<E> {

  HashSet<BSTNode<E>> visited;
  Stack<BSTNode<E>> s;

  public PreOrderTraversalIterator(BSTNode<E> root) {
    this.nextNode = root;

    this.visited = new HashSet<BSTNode<E>>();
    this.visited.add(this.nextNode);

    this.s = new Stack<BSTNode<E>>();
    this.s.push(this.nextNode);
  }

  public boolean hasNext() {
    return this.nextNode != null;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();

    E returnValue = this.nextNode.data;

    boolean foundNext = false;
    while(!foundNext && this.nextNode != null) {
      if(this.nextNode.left != null  && !this.visited.contains(this.nextNode.left)) {
        this.visited.add(this.nextNode.left);
        this.s.push(this.nextNode.left);
        foundNext = true;
      } else if(this.nextNode.right != null && !this.visited.contains(this.nextNode.right)) {
        this.visited.add(this.nextNode.right);
        this.s.push(this.nextNode.right);
        foundNext = true;
      } else {
        this.nextNode = this.s.pop();
      }
    }

    this.nextNode = this.s.peek();
    return returnValue;
  }

}
