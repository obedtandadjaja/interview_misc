package DataStructures;

import DataStructures.abstracts.LinkedListNodeAbstract;

import java.util.*;

public class LinkedListNode<E extends Comparable<E>> extends LinkedListNodeAbstract<E> implements Comparable<LinkedListNode<E>> {
  public LinkedListNode prev;
  public LinkedListNode next;

  public LinkedListNode(LinkedListNode<E> prev, E data, LinkedListNode<E> next) {
    this.prev = prev;
    this.data = data;
    this.next = next;
  }

  public int compareTo(LinkedListNode<E> node) {
    return this.data.compareTo(node.data);
  }
}
