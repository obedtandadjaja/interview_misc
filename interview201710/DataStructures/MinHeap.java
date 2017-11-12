package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.HeapAbstract;

import java.util.*;
import java.lang.Math;

public class MinHeap<E extends Comparable<E>> extends HeapAbstract<E> {
  public MinHeap() {
    super();
  }

  public void restructureHeapUp(int position) {
    int parentIndex = position/2;
    if(parentIndex > 0 && this.heap[position].compareTo(this.heap[parentIndex]) < 0) {
      swap(position, parentIndex);
      restructureHeapUp(parentIndex);
    }
  }

  public void restructureHeapDown(int position) {
    int leftChildIndex = position*2;
    int rightChildIndex = position*2+1;
    if(this.heap[position].compareTo(this.heap[leftChildIndex]) > 0 && leftChildIndex < this.size) {
      swap(position, leftChildIndex);
      restructureHeapDown(leftChildIndex);
    } else if(this.heap[position].compareTo(this.heap[rightChildIndex]) > 0 && rightChildIndex < this.size) {
      swap(position, rightChildIndex);
      restructureHeapDown(rightChildIndex);
    }
  }
}
