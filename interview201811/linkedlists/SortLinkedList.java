/*
  Difficulty: Medium

  Sort a linked list in O(n log n) time using constant space complexity.

  Example :

  Input : 1 -> 5 -> 4 -> 3

  Returned list : 1 -> 3 -> 4 -> 5
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
  public ListNode sortList(ListNode A) {
    return sortHelper(A);
  }

  public ListNode sortHelper(ListNode start) {
    if(start.next == null) return start;

    ListNode prev = null;
    ListNode slow = start;
    ListNode fast = start;

    // node that fast pointer will point to n/2 + 1
    // e.g. [1,2,3,4] - fast: 3
    // need prev to point to 2
    while(fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }

    // change prev to null so that it's 2 separate lists
    prev.next = null;

    ListNode head1 = sortHelper(start);
    ListNode head2 = sortHelper(slow);

    // merge sort
    ListNode head = new ListNode(0);
    ListNode curr = head;
    while(head1 != null || head2 != null) {
      if(head1 == null) {
        curr.next = head2;
        head2 = head2.next;
      } else if(head2 == null) {
        curr.next = head1;
        head1 = head1.next;
      } else if(head1.val < head2.val) {
        curr.next = head1;
        head1 = head1.next;
      } else {
        curr.next = head2;
        head2 = head2.next;
      }
      curr = curr.next;
    }

    // make tail to point to null
    curr.next = null;

    return head.next;
  }
}
