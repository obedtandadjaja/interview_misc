package DataStructures;

import DataStructures.abstracts.HashTableAbstract;
import DataStructures.HashEntry;

import java.util.*;

public class HashTable<K extends Comparable<K>, V> extends HashTableAbstract<K, V> {
  public HashTable() {
    this.size = 0;
    this.entries = new LinkedList[10];
  }

  public void put(K key, V value) {
    if(!containsKey(key)) {
      if(this.size == this.entries.length) grow();

      int hash = key.hashCode() % this.entries.length;
      if(this.entries[hash] == null) this.entries[hash] = new LinkedList<HashEntry<K, V>>();
      this.entries[hash].add(new HashEntry<K, V>(key, value));

      this.size++;
    }
  }

  public V get(K key) throws Exception {
    if(containsKey(key)) {
      int hash = key.hashCode() % this.entries.length;
      for(HashEntry<K, V> entry : this.entries[hash]) {
        if(entry.getKey() == key) return entry.getValue();
      }
      return null; // code should not get to this but just as a safety measure
    } else {
      throw new Exception("Key not found");
    }
  }

  public void delete(K key) {
    if(containsKey(key)) {
      int hash = key.hashCode() % this.entries.length;
      for(int i = 0; i < this.entries[hash].size(); i++) {
        if(this.entries[hash].get(i).getKey() == key) {
          this.entries[hash].removeByIndex(i);
          break;
        }
      }
      this.size--;
    }
  }

  public int size() {
    return this.size;
  }

  public boolean containsKey(K key) {
    int hash = key.hashCode() % this.entries.length;
    if(this.entries[hash] == null || this.entries[hash].size() == 0) return false;
    for(HashEntry<K, V> entry : this.entries[hash]) {
      if(entry.getKey() == key) return true;
    }
    return false;
  }

  public void grow() {
    LinkedList<HashEntry<K, V>>[] newEntries = new LinkedList[this.entries.length * 2];
    for(int i = 0; i < this.entries.length; i++) {
      if(this.entries[i] != null) {
        for(HashEntry<K, V> entry : this.entries[i]) {
          int newHash = entry.getKey().hashCode() % newEntries.length;
          if(newEntries[newHash] == null) newEntries[newHash] = new LinkedList<HashEntry<K, V>>();
          newEntries[newHash].add(entry);
        }
      }
    }
    this.entries = newEntries;
  }
}
