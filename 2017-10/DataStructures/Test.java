package DataStructures;

import DataStructures.HashTable;
import DataStructures.BinaryTree;

public class Test {
  public static void main(String[] args) {
    Test t = new Test();
    // t.startHashTableExample();
    t.startBinaryTreeExample();
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

  public void startBinaryTreeExample() {
    BinaryTree<Integer> bst = new BinaryTree<Integer>();

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
}
