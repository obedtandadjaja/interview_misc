package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class Intersection {

  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    LinkedList<Integer> ll2 = new LinkedList<Integer>();

    ll1.add(1); ll1.add(2); ll1.add(3); ll1.add(5);
    ll2.add(4); ll2.head.next = ll1.tail;
    ll1.add(7); ll1.add(8);

    System.out.println("1->2->3->5->7->8");
    System.out.println("4->5->7->8");
    System.out.println("intersection: " + findIntersection(ll1.head, ll2.head));
  }

  public static int findIntersection(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
    int length1 = linkedListLength(head1);
    int length2 = linkedListLength(head2);

    if(length1 > length2) head1 = skipNodes(head1, length1-length2);
    else if(length2 > length1) head2 = skipNodes(head2, length2-length1);

    while(head1 != head2) {
      head1 = head1.next;
      head2 = head2.next;
    }
    return head1 != null ? head1.data : -1;
  }

  public static int linkedListLength(LinkedListNode<Integer> head) {
    int length = 0;
    LinkedListNode<Integer> curr = head;
    while(curr != null) {
      length++;
      curr = curr.next;
    }

    return length;
  }

  public static LinkedListNode<Integer> skipNodes(LinkedListNode<Integer> head, int count) {
    for(int i = 0; i < count; i++) if(head != null) head = head.next;
    return head;
  }
}
