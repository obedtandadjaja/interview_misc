package DataStructures.abstracts;

import DataStructures.LinkedListNode;

import java.util.*;

public abstract class LinkedListIteratorAbstract<E extends Comparable<E>> implements Iterator<E> {
  protected LinkedListNode<E> nextNode;

  @Override
  public abstract boolean hasNext();

  @Override
  public abstract E next();
}
