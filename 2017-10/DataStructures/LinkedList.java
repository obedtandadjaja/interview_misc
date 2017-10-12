package DataStructures;

import DataStructures.abstracts.LinkedListAbstract;
import DataStructures.LinkedListNode;

import java.util.*;

public class LinkedList<E extends Comparable<E>> extends LinkedListAbstract<E> {

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void add(E data) {
    if(this.head == null) {
      this.head = new LinkedListNode<E>(null, data, null);
      this.tail = this.head;
    } else if(this.head == this.tail) {
      this.tail = new LinkedListNode<E>(this.head, data, null);
      this.head.next = this.tail;
    } else {
      this.tail.next = new LinkedListNode<E>(this.tail, data, null);
      this.tail = this.tail.next;
    }

    this.size++;
  }

  public void removeByIndex(int index) {
    if(index < 0 || index > this.size-1) return;
    if(index == 0) {
      this.head = this.head.next;
      if(this.head != null) this.head.prev = null;
    } else if(index == this.size-1) {
      this.tail = this.tail.prev;
      if(this.tail != null) this.tail.next = null;
    } else {
      LinkedListNode<E> curr = this.head;
      for(int i = 0; i < index; i++) curr = curr.next;

      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }

    this.size--;
  }

  public void remove(E data) {
    if(lookup(data)) {
      LinkedListNode<E> curr = this.head;

      while(curr != null) {
        if(curr.data.compareTo(data) == 0) break;
        curr = curr.next;
      }

      // deleting curr
      if(curr == this.head) {
        this.head = this.head.next;
        if(this.head != null) this.head.prev = null;
      } else if(curr == this.tail) {
        this.tail = this.tail.prev;
        if(this.tail != null) this.tail.next = null;
      } else {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
      }

      this.size--;
    }
  }

  public boolean lookup(E data) {
    LinkedListNode<E> curr = this.head;
    while(curr != null) {
      if(curr.data.compareTo(data) == 0) return true;
      curr = curr.next;
    }
    return false;
  }

  public E get(int index) {
    if(index == 0) return this.head.data;
    if(index == this.size-1) return this.tail.data;

    LinkedListNode<E> curr = this.head;
    for(int i = 0; i < index; i++) curr = curr.next;

    return curr.data;
  }
}
