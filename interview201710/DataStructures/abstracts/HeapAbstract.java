package interview201710.DataStructures.abstracts;

import java.util.*;

public abstract class HeapAbstract<E extends Comparable<E>> {
  public E[] heap;
  public int size;

  public HeapAbstract() {
    this.heap = (E[]) new Comparable[10];
    this.size = 0;
  }

  public abstract void restructureHeapUp(int position);
  public abstract void restructureHeapDown(int position);

  public void insert(E data) {
    if(size() == this.heap.length) grow();

    this.heap[this.size+1] = data;
    restructureHeapUp(this.size+1);

    this.size++;
  }

  public E removeTop() {
    E returnValue = this.heap[1];
    this.heap[1] = this.heap[this.size];
    this.size--;
    restructureHeapDown(1);

    return returnValue;
  }

  public int size() {
    return this.size;
  }

  public void grow() {
    E[] newHeap = (E[]) new Comparable[this.heap.length*2];
    for(int i = 0; i < this.heap.length; i++)
      newHeap[i] = this.heap[i];
    this.heap = newHeap;
  }

  public void swap(int position1, int position2) {
    E temp = this.heap[position1];
    this.heap[position1] = this.heap[position2];
    this.heap[position2] = temp;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 1; i < size()+1; i++)
      sb.append(this.heap[i].toString() + ", ");
    return sb.toString();
  }
}
