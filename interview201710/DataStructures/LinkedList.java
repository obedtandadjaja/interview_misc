package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.LinkedListAbstract;
import interview201710.DataStructures.LinkedListNode;

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

  public void insert(int index, E data) {
    if(index == size()) {
      add(data);
    } else if(index == 0) {
      this.head = new LinkedListNode<E>(null, data, this.head);
      this.size++;
    } else {
      LinkedListNode<E> curr = this.head;
      for(int i = 0; i < index; i++) {
        if(curr.next != null) curr = curr.next;
      }

      LinkedListNode<E> insertedNode = new LinkedListNode<E>(curr.prev, data, curr.next);
      if(curr.prev != null) curr.prev.next = insertedNode;
      if(curr.next != null) curr.next.prev = insertedNode;

      this.size++;
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

  public void reverse() {
    LinkedListNode<E> current = this.head;
    LinkedListNode<E> currentHead = this.head;
    while(current.next != null) {
      LinkedListNode<E> nodeToMove = current.next;
      current.next = nodeToMove.next;
      nodeToMove.next = currentHead;
      currentHead.prev = nodeToMove;
      currentHead = nodeToMove;
    }

    this.head = currentHead;
    this.tail = current;
  }

  public E get(int index) {
    if(index == 0) return this.head.data;
    if(index == this.size-1) return this.tail.data;

    LinkedListNode<E> curr = this.head;
    for(int i = 0; i < index; i++) curr = curr.next;

    return curr.data;
  }
}
