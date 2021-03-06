package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.HashEntry;
import interview201710.DataStructures.LinkedList;

import java.util.*;

public abstract class HashTableAbstract<K extends Comparable<K>, V> {
  protected int size;
  protected LinkedList<HashEntry<K, V>>[] entries;
  public abstract void put(K key, V value);
  public abstract V get(K key) throws Exception;
  public abstract void delete(K key);
  public abstract int size();
  public abstract boolean containsKey(K key);
  public abstract void grow();
}
