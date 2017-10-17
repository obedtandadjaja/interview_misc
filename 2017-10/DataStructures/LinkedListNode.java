package DataStructures;

import DataStructures.abstracts.LinkedListNodeAbstract;

public class LinkedListNode<E> extends LinkedListNodeAbstract<E> {
  public LinkedListNode prev;
  public LinkedListNode next;

  public LinkedListNode(LinkedListNode<E> prev, E data, LinkedListNode<E> next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }
}
