import java.util.*;

public class HashTableExample {
  public static void main(String[] args) {
    HashTableExample ex = new HashTableExample();
    ex.startHashTableExample();
  }

  public void startHashTableExample() {
    HashTable<String, String> contacts = new HashTable<String, String>();

    contacts.put("Obed", "5594737555");
    contacts.put("Hello", "1234567890");
    contacts.put("Hi", "9876543210");
    contacts.put("Red", "5555555555");
    contacts.put("Blue", "7777777777");

    try {
      System.out.println("Obed: " + contacts.get("Obed"));
      System.out.println("Red: " + contacts.get("Red"));
      System.out.println("Blue: " + contacts.get("Blue"));
    } catch(Exception e) {
    }

    System.out.println("size: " + contacts.size());

    contacts.delete("Obed");
    contacts.delete("Red");

    System.out.println("size: " + contacts.size());

    System.out.println("contains 'Hello'? " + (contacts.containsKey("Hello") ? "Yes" : "No"));
    System.out.println("contains 'Obed'? " + (contacts.containsKey("Obed") ? "Yes" : "No"));
  }

  // HashTable Separate Chaining implementation
  public abstract class HashTableAbstract<K, V> {
    protected int size;
    protected LinkedList<HashEntry<K, V>>[] entries;
    protected abstract void put(K key, V value);
    protected abstract V get(K key) throws Exception;
    protected abstract void delete(K key);
    protected abstract int size();
    protected abstract boolean containsKey(K key);
    protected abstract void grow();
  }

  public class HashEntry<K, V> {
    private K key;
    private V value;
    HashEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }

    public K getKey() { return this.key; }
    public V getValue() { return this.value; }
  }

  private class HashTable<K, V> extends HashTableAbstract<K, V> {
    public HashTable() {
      this.size = 0;
      this.entries = new LinkedList[10];
    }

    protected void put(K key, V value) {
      if(!containsKey(key)) {
        if(this.size == this.entries.length) grow();

        int hash = key.hashCode() % this.entries.length;
        if(this.entries[hash] == null) this.entries[hash] = new LinkedList<HashEntry<K, V>>();
        this.entries[hash].add(new HashEntry<K, V>(key, value));

        this.size++;
      }
    }

    protected V get(K key) throws Exception {
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

    protected void delete(K key) {
      if(containsKey(key)) {
        int hash = key.hashCode() % this.entries.length;
        for(int i = 0; i < this.entries[hash].size(); i++) {
          if(this.entries[hash].get(i).getKey() == key) {
            this.entries[hash].remove(i);
            break;
          }
        }
        this.size--;
      }
    }

    protected int size() {
      return this.size;
    }

    protected boolean containsKey(K key) {
      int hash = key.hashCode() % this.entries.length;
      if(this.entries[hash] == null || this.entries[hash].size() == 0) return false;
      for(HashEntry<K, V> entry : this.entries[hash]) {
        if(entry.getKey() == key) return true;
      }
      return false;
    }

    protected void grow() {
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
}
