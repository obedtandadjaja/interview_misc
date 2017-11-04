package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.LinkedList;

import java.util.*;

public abstract class StackAbstract<E> {
  protected LinkedList<E> ll;

  public void push(E data) {
    this.ll.add(data);
  }

  public E pop() {
    return this.ll.removeByIndex(this.ll.size()-1);
  }

  public E peek() {
    return this.ll.tail != null ? this.ll.tail.data : null;
  }

  public int size() {
    return this.ll.size();
  }

  public String toString() {
    StringBuilder str = new StringBuilder();
    for(E data : this.ll) {
      str.insert(0, data + ", ");
    }
    return str.toString();
  }
}
