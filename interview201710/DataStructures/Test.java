package interview201710.DataStructures;

public class Test {
  public static void main(String[] args) {
    Test t = new Test();
    t.startHashTableExample();
    t.startBinaryTreeExample();
    t.startLinkedListExample();
    t.startStackExample();
    t.startQueueExample();
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

    try {
      System.out.println("\nInserting 99 at 8:");
      ll.insert(8, 99);
      System.out.println(ll.toString());

      System.out.println("\nInserting 99 at 0:");
      ll.insert(0, 99);
      System.out.println(ll.toString());

      System.out.println("\nInserting 99 at 5:");
      ll.insert(5, 99);
      System.out.println(ll.toString());

      System.out.println("\nInserting 99 at 100:");
      ll.insert(100, 99);
      System.out.println(ll.toString());
    } catch(Exception e) {
      System.out.println(e.toString());
    }

    System.out.print("\nReversing: ");
    ll.reverse();
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

    System.out.print("\nDeleting by index 0: ");
    ll.removeByIndex(0);
    System.out.println(ll.toString());

    System.out.println("\nSize: " + ll.size());
  }

  public void startStackExample() {
    Stack<Integer> s = new Stack<Integer>();

    System.out.println("\n---------------------------");
    System.out.println("Stack test");
    System.out.println("---------------------------");

    System.out.println("adding 1-5 ...");
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);
    s.push(5);

    System.out.println(s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPopping: ");
    System.out.println(s.pop());
    System.out.println("Result: " + s.toString());
  }

  public void startQueueExample() {
    Queue<Integer> s = new Queue<Integer>();

    System.out.println("\n---------------------------");
    System.out.println("Queue test");
    System.out.println("---------------------------");

    System.out.println("adding 1-5 ...");
    s.add(1);
    s.add(2);
    s.add(3);
    s.add(4);
    s.add(5);

    System.out.println(s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());

    System.out.print("\nPolling: ");
    System.out.println(s.poll());
    System.out.println("Result: " + s.toString());
  }
}
