package interview201710.DataStructures.interfaces;

import interview201710.DataStructures.interfaces.Searcher;

public interface Searchable<E> {
  public Searcher<E> searcher();
}
