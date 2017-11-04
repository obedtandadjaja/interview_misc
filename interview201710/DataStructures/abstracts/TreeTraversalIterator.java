package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.BSTNode;
import java.util.*;

public abstract class TreeTraversalIterator<E> implements Iterator<E> {
  protected BSTNode<E> nextNode;

  @Override
  public abstract boolean hasNext();

  @Override
  public abstract E next();
}
