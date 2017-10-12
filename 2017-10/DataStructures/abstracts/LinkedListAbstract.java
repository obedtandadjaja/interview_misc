package DataStructures.abstracts;

import DataStructures.LinkedListNode;
import DataStructures.iterators.LinkedListIterator;

import java.util.*;

public abstract class LinkedListAbstract<E extends Comparable<E>> implements Iterable<E> {
  public LinkedListNode<E> head;
  public LinkedListNode<E> tail;
  protected int size;

  public abstract void add(E data);
  public abstract void remove(E data);
  public abstract void removeByIndex(int index);
  public abstract boolean lookup(E data);
  public abstract E get(int index);

  public int size() {
    return this.size;
  }

  public Iterator<E> iterator() {
    return new LinkedListIterator(this.head);
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
