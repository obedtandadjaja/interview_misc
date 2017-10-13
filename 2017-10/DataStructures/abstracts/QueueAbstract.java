package DataStructures.abstracts;

import DataStructures.LinkedList;

import java.util.*;

public abstract class QueueAbstract<E extends Comparable<E>> {
  protected LinkedList<E> ll;

  // can be normal or priority queue - depends on the implementation
  public abstract void add(E data);

  public E poll() {
    return this.ll.removeByIndex(0);
  }

  public int size() {
    return this.ll.size();
  }

  public String toString() {
    return this.ll.toString();
  }

}
