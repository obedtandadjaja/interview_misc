package interview201710.DataStructures;

import interview201710.DataStructures.iterators.ArrayListIterator;
import interview201710.DataStructures.LinkedList;

import java.lang.Iterable;
import java.util.Iterator;

public class ArrayList<E> implements Iterable<E> {
  E[] array;
  int size;

  public ArrayList() {
    this.array = (E[]) new Object[10];
    this.size = 0;
  }

  public ArrayList(int size) {
    this.array = (E[]) new Object[size];
    this.size = 0;
  }

  public void grow() {
    E[] new_array = (E[]) new Object[this.array.length*2];
    for(int i = 0; i < this.array.length; i++)
      new_array[i] = this.array[i];
    this.array = new_array;
  }

  public void add(E data) {
    if(this.array.length <= this.size) grow();

    this.array[this.size] = data;
    this.size++;
  }

  public void insert(E data, int index) {
    if(this.array.length <= this.size) grow();
    while(this.array.length <= index) grow();

    for(int i = this.size-1; i >= index; i--)
      this.array[i+1] = this.array[i];

    this.array[index] = data;
    this.size = this.size+1 < index+1 ? index+1 : this.size+1;
  }

  public E get(int index) {
    return this.array[index];
  }

  public E remove(int index) {
    E returnValue = this.array[index];

    for(int i = index; i < this.size; i++)
      this.array[i] = this.array[i+1];
    this.array[this.size-1] = null;
    this.size--;

    return returnValue;
  }

  public E remove(E data) {
    for(int i = 0; i < this.size; i++) {
      if(this.array[i] == data) {
        E returnValue = this.array[i];
        remove(i);
      }
    }
    return null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < this.size; i++)
      sb.append(this.array[i] + ", ");
    return sb.toString();
  }

  public int size() {
    return this.size;
  }

  public Iterator<E> iterator() {
    return new ArrayListIterator(this.array, this.size);
  }

  public void addAll(ArrayList<E> arrayList) {
    for(E data : arrayList) add(data);
  }

  public void addAll(LinkedList<E> ll) {
    for(E data : ll) add(data);
  }
}
