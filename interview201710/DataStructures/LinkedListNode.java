package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.LinkedListNodeAbstract;

public class LinkedListNode<E> extends LinkedListNodeAbstract<E> {
  public LinkedListNode prev;
  public LinkedListNode next;

  public LinkedListNode(LinkedListNode<E> prev, E data, LinkedListNode<E> next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }

  public LinkedListNode() {
    this.prev = null;
    this.next = null;
  }

  public E getData() {
    return this.data;
  }
}
