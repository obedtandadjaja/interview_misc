package DataStructures.iterators;

import DataStructures.abstracts.TreeTraversalIterator;
import DataStructures.BSTNode;
import DataStructures.Stack;

import java.util.*;

public class PostOrderTraversalIterator<E extends Comparable<E>> extends TreeTraversalIterator<E> {

  HashSet<BSTNode<E>> visited;
  Stack<BSTNode<E>> s;

  public PostOrderTraversalIterator(BSTNode<E> root) {
    this.visited = new HashSet<BSTNode<E>>();
    this.s = new Stack<BSTNode<E>>();
    this.s.push(root);
    while(this.s.peek() != null) {
      if(this.s.peek().left != null) {
        this.s.push(this.s.peek().left);
      } else if(this.s.peek().right != null) {
        this.s.push(this.s.peek().right);
      } else {
        break;
      }
    }
    this.nextNode = this.s.pop();
    this.visited.add(this.nextNode);
  }

  public boolean hasNext() {
    return this.nextNode != null;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();

    E returnValue = this.nextNode.data;

    boolean foundNext = false;
    while(!foundNext && this.s.peek() != null) {
      if(this.s.peek().left != null  && !this.visited.contains(this.s.peek().left)) {
        this.s.push(this.s.peek().left);
      } else if(this.s.peek().right != null && !this.visited.contains(this.s.peek().right)) {
        this.s.push(this.s.peek().right);
      } else {
        foundNext = true;
      }
    }

    this.nextNode = this.s.pop();
    this.visited.add(this.nextNode);
    return returnValue;
  }

}
