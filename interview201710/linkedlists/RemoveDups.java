package interview201710.linkedlists;

import interview201710.DataStructures.*;
import java.util.*;

public class RemoveDups {

  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(1); ll1.add(1); ll1.add(3); ll1.add(5); ll1.add(5);
    System.out.println("Before: " + ll1.toString());
    ll1.head = removeDuplicates(ll1.head);
    System.out.println("After remove duplicates: " + ll1.toString());
  }

  public LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
    HashSet<Integer> set = new HashSet<Integer>();
    set.add(head.data);
    LinkedListNode<Integer> curr = head;
    while(curr.next != null) {
      if(set.contains(curr.next.data)) {
        curr.next = curr.next.next;
        curr.next.prev = curr;
      } else {
        set.add(curr.data);
        curr = curr.next;
      }
    }

    return head;
  }
}
