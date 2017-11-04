package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class LoopDetection {
  public static void main(String[] args) {
    LinkedListNode<Integer> head = new LinkedListNode(null, 1, null);
    LinkedListNode<Integer> two = new LinkedListNode(null, 2, null);
    LinkedListNode<Integer> three = new LinkedListNode(null, 3, null);
    LinkedListNode<Integer> beginLoop = new LinkedListNode(null, 4, null);
    LinkedListNode<Integer> five = new LinkedListNode(null, 5, null);
    LinkedListNode<Integer> six = new LinkedListNode(null, 6, null);
    LinkedListNode<Integer> seven = new LinkedListNode(null, 7, null);
    LinkedListNode<Integer> eight = new LinkedListNode(null, 8, null);
    LinkedListNode<Integer> nine = new LinkedListNode(null, 9, null);
    LinkedListNode<Integer> ten = new LinkedListNode(null, 10, null);

    head.next = two;
    two.next = three;
    three.next = beginLoop;
    beginLoop.next = five;
    five.next = six;
    six.next = seven;
    seven.next = eight;
    eight.next = nine;
    nine.next = ten;
    ten.next = beginLoop;

    System.out.println("1->2->3->4->5->6->7->8->9->10->4: " + getStartOfLoop(head).data);
  }

  public static LinkedListNode<Integer> getStartOfLoop(LinkedListNode<Integer> head) {
    if(head == null) return null;

    LinkedListNode<Integer> curr = head;
    LinkedListNode<Integer> runner = head;

    while(runner != null && runner.next != null) {
      curr = curr.next;
      runner = runner.next.next;
      if(curr == runner) break;
    }

    if(runner == null || runner.next == null) return null;

    curr = head;
    while(curr != runner) {
      curr = curr.next;
      runner = runner.next;
    }

    return curr;
  }
}
