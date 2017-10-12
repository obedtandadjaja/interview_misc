package DataStructures;

import java.util.*;

public class HashEntry<K extends Comparable<K>, V> implements Comparable<HashEntry<K, V>> {
  private K key;
  private V value;
  HashEntry(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() { return this.key; }
  public V getValue() { return this.value; }

  public int compareTo(HashEntry<K, V> entry) {
    return this.key.compareTo(entry.key);
  }
}
