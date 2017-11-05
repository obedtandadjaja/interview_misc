package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class ReturnKthToLast {
  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(1); ll1.add(1); ll1.add(3); ll1.add(5); ll1.add(5);
    System.out.println("LL: " + ll1.toString());
    System.out.println("3rd from last: " + returnKthToLast(ll1.head.data));
  }

  public static LinkedListNode<Integer> returnKthToLast(LinkedListNode<Integer> head, int k) {
    LinkedListNode<Integer> curr1 = head;
    LinkedListNode<Integer> curr2 = head;
    for(int i = 0; i < k; i++) {
      curr1 = curr1.next;
    }

    while(curr1 != null) {
      curr1 = curr1.next;
      curr2 = curr2.next;
    }

    return curr2;
  }
}
