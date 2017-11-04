package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.LinkedList;

import java.util.*;

public abstract class QueueAbstract<E> {
  protected LinkedList<E> ll;

  // can be normal or priority queue - depends on the implementation
  public abstract void add(E data);

  public E poll() {
    return this.ll.removeByIndex(0);
  }

  public E peek() {
    return this.ll.head == null ? null : this.ll.head.data;
  }

  public int size() {
    return this.ll.size();
  }

  public String toString() {
    return this.ll.toString();
  }

}
