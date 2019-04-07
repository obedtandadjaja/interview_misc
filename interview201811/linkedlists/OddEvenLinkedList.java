/*
  Difficulty: Medium

  Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

  You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

  Example 1:

  Input: 1->2->3->4->5->NULL
  Output: 1->3->5->2->4->NULL
  Example 2:

  Input: 2->1->3->5->6->4->7->NULL
  Output: 2->3->6->7->1->5->4->NULL
  Note:

  The relative order inside both the even and odd groups should remain as it was in the input.
  The first node is considered odd, the second node even and so on ...
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
  // 1: without counter
  public ListNode oddEvenList(ListNode head) {
    if(head == null) return null;

    ListNode odd = head;
    ListNode evenHead = head.next;
    ListNode even = head.next;

    while(even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;

      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;

    return head;
  }

  // 2: with counter and current Node
  public ListNode oddEvenList(ListNode head) {
    if(head.next == null) return head;

    ListNode odd = head;
    ListNode evenHead = head.next;
    ListNode even = head.next;
    ListNode curr = head.next.next;

    int count = 1;
    while(curr != null) {
      if(count % 2 == 0) {
        even.next = curr;
        even = even.next;
      } else {
        odd.next = curr;
        odd = odd.next;
      }

      count++;
      curr = curr.next;
    }
    even.next = null; // make the tail.next = null

    odd.next = evenHead; // join odd and even

    return head;
  }
}
