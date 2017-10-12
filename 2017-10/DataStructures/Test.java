package DataStructures;

import DataStructures.HashTable;
import DataStructures.BinaryTree;
import DataStructures.LinkedList;

public class Test {
  public static void main(String[] args) {
    Test t = new Test();
    t.startHashTableExample();
    t.startBinaryTreeExample();
    t.startLinkedListExample();
  }

  public void startHashTableExample() {
    HashTable<String, String> contacts = new HashTable<String, String>();

    System.out.println("\n---------------------------");
    System.out.println("HashTable test");
    System.out.println("---------------------------");

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

  public void startBinaryTreeExample() {
    BinaryTree<Integer> bst = new BinaryTree<Integer>();

    System.out.println("\n---------------------------");
    System.out.println("BinaryTree test");
    System.out.println("---------------------------");

    bst.add(5);
    bst.add(9);
    bst.add(10);
    bst.add(0);
    bst.add(3);
    bst.add(6);
    bst.add(7);
    bst.add(8);
    bst.add(2);
    bst.add(1);
    bst.add(4);

    System.out.print("Current: ");
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 5: ");
    bst.delete(5);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 1: ");
    bst.delete(1);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 6: ");
    bst.delete(6);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 8: ");
    bst.delete(8);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 9: ");
    bst.delete(9);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 10: ");
    bst.delete(10);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 2: ");
    bst.delete(2);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 3: ");
    bst.delete(3);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 0: ");
    bst.delete(0);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 4: ");
    bst.delete(4);
    System.out.println(bst.toString());
    System.out.println();

    System.out.print("Deleting 7: ");
    bst.delete(7);
    System.out.println(bst.toString());
    System.out.println();
  }

  public void startLinkedListExample() {
    LinkedList<Integer> ll = new LinkedList<Integer>();

    System.out.println("\n---------------------------");
    System.out.println("LinkedList test");
    System.out.println("---------------------------");

    System.out.println("adding 0-7 ...");
    ll.add(0);
    ll.add(1);
    ll.add(2);
    ll.add(3);
    ll.add(4);
    ll.add(5);
    ll.add(6);
    ll.add(7);

    System.out.println(ll.toString());

    System.out.println("\nSize: " + ll.size());

    System.out.print("\nDeleting 7: ");
    ll.remove(7);
    System.out.println(ll.toString());

    System.out.print("\nDeleting 0: ");
    ll.remove(0);
    System.out.println(ll.toString());

    System.out.print("\nDeleting 3: ");
    ll.remove(3);
    System.out.println(ll.toString());

    System.out.print("\nDeleting 1: ");
    ll.remove(1);
    System.out.println(ll.toString());

    System.out.print("\nDeleting by index 0: ");
    ll.removeByIndex(0);
    System.out.println(ll.toString());

    System.out.print("\nDeleting by index 2: ");
    ll.removeByIndex(2);
    System.out.println(ll.toString());

    System.out.print("\nDeleting by index 1: ");
    ll.removeByIndex(1);
    System.out.println(ll.toString());

    System.out.print("\nDeleting by index 0: ");
    ll.removeByIndex(0);
    System.out.println(ll.toString());

    System.out.println("\nSize: " + ll.size());
  }
}
