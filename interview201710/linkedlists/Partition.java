package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class Partition {
  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(9); ll1.add(12); ll1.add(3); ll1.add(5); ll1.add(5);
    System.out.println("LL: " + ll1.toString());
    ll1.head = partition(ll1.head, 6);
    System.out.println("After partition - 6:" + ll1.toString());
  }

  public static LinkedListNode<Integer> partition(LinkedListNode<Integer> head, int partition) {
    LinkedListNode<Integer> currentHead = head;
    LinkedListNode<Integer> curr = head;

    while(curr.next != null) {
      if((Integer)curr.next.data < partition) {
        LinkedListNode<Integer> newHead = curr.next;
        curr.next = newHead.next;
        newHead.next = currentHead;
        currentHead = newHead;
      } else {
        curr = curr.next;
      }
    }

    return currentHead;
  }
}
