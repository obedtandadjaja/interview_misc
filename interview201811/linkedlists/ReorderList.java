/*
  Difficulty: Medium

  Given a singly linked list L: L0→L1→…→Ln-1→Ln,
  reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

  You may not modify the values in the list's nodes, only nodes itself may be changed.

  Example 1:

  Given 1->2->3->4, reorder it to 1->4->2->3.
  Example 2:

  Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  // 1: use a stack to store all nodes and count the length
  //    go half way and connect top of stack to current
  public void reorderList(ListNode head) {
    if(head == null) return;

    Stack<ListNode> stack = new Stack();

    int length = 0;
    ListNode curr = head;
    while(curr != null) {
      stack.push(curr);
      curr = curr.next;
      length++;
    }

    curr = head;
    int i = 0;
    while(i < length / 2) {
      ListNode temp = curr.next;

      curr.next = stack.pop();
      curr.next.next = temp;

      curr = temp;
    }
    curr.next = null;
  }


  // 2: find the middle and have 2 pointers to go opposite directions and connect each other
  public void reorderList(ListNode head) {
    if(head == null) return;

    Stack<ListNode> stack = new Stack();

    // we want to find the middle and then do two pointers that go in opposite directions
    // use runner to go 2 at a time and get the middle
    ListNode pivot = head, runner = head;
    while(runner != null && runner.next != null) {
      stack.push(pivot);

      pivot = pivot.next;
      runner = runner.next.next;
    }

    ListNode tail = null;

    // when runner == null then the linkedlist is even
    if(runner == null) {
      tail = pivot;
    } else {
      // skipping the middle since it does not require any changes
      tail = pivot;
      pivot = pivot.next;
    }

    // connect what's in the stack to the pivot
    ListNode popped = null, pivotNext = null, poppedNext = null;
    while(!stack.isEmpty()) {
      popped = stack.pop();
      pivotNext = pivot.next;
      poppedNext = popped.next;

      popped.next = pivot;
      pivot.next = poppedNext;

      pivot = pivotNext;
    }

    tail.next = null;
  }
}
