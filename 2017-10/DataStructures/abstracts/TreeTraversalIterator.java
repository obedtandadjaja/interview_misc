package DataStructures.abstracts;

import DataStructures.BSTNode;
import java.util.*;

public abstract class TreeTraversalIterator implements Iterator<BSTNode> {
  protected BSTNode nextNode;

  @Override
  public abstract boolean hasNext();

  @Override
  public abstract BSTNode next();
}
