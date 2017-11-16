package interview201710.DataStructures.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListIterator<E> implements Iterator<E>  {
  protected E[] array;
  protected int size;
  protected int index;

  public ArrayListIterator(E[] array, int size) {
    this.array = array;
    this.size = size;
    this.index = 0;
  }

  public boolean hasNext() {
    return this.index < this.size;
  }

  public E next() {
    if(!hasNext()) throw new NoSuchElementException();
    E returnValue = this.array[this.index];
    this.index++;
    return returnValue;
  }
}
