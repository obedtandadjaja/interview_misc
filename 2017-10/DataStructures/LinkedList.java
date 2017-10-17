package DataStructures;

import DataStructures.abstracts.LinkedListAbstract;
import DataStructures.LinkedListNode;

import java.util.*;

public class LinkedList<E> extends LinkedListAbstract<E> {

  public LinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public void add(E data) {
    if(this.head == null) { // if ll is empty then head == tail
      this.head = new LinkedListNode<E>(null, data, null);
      this.tail = this.head;
    } else if(this.head == this.tail) { // if ll size == 1 then break off head and tail
      this.tail = new LinkedListNode<E>(this.head, data, null);
      this.head.next = this.tail;
    } else {
      this.tail.next = new LinkedListNode<E>(this.tail, data, null);
      this.tail = this.tail.next;
    }

    this.size++;
  }

  public void insert(int index, E data) throws Exception {
    if(index == size()) add(data);
    else {
      LinkedListNode<E> curr = this.head;
      for(int i = 0; i < index; i++) {
        if(curr.next != null) curr = curr.next;
        else throw new Exception("LinkedList size is less than index.");
      }

      LinkedListNode<E> insertedNode = new LinkedListNode<E>(curr.prev, data, curr.next);
      if(curr.prev != null) curr.prev.next = insertedNode;
      if(curr.next != null) curr.next.prev = insertedNode;
      if(curr == this.head) this.head = insertedNode;
    }
  }

  public E removeByIndex(int index) {
    if(index < 0 || index > this.size-1) return null;

    LinkedListNode<E> curr = null;

    if(index == 0) {
      curr = this.head;
      this.head = this.head.next;
      if(this.head != null) this.head.prev = null;
    } else if(index == this.size-1) {
      curr = this.tail;
      this.tail = this.tail.prev;
      if(this.tail != null) this.tail.next = null;
    } else {
      curr = this.head;
      for(int i = 0; i < index; i++) curr = curr.next;

      curr.prev.next = curr.next;
      curr.next.prev = curr.prev;
    }

    this.size--;
    if(this.size == 0) this.head = this.tail = null;

    return curr != null ? curr.data : null;
  }

  public E remove(E data) {
    LinkedListNode<E> curr = this.head;

    if(lookup(data)) {
      // searching for the data
      while(curr != null) {
        if(curr.data.equals(data)) break;
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

    return curr != null ? curr.data : null;
  }

  public boolean lookup(E data) {
    LinkedListNode<E> curr = this.head;
    while(curr != null) {
      if(curr.data.equals(data)) return true;
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
