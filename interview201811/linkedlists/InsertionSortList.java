/*
  Difficulty: Medium

  Sort a linked list using insertion sort.

  We have explained Insertion Sort at Slide 7 of Arrays

  Insertion Sort Wiki has some details on Insertion Sort as well.

  Example :

  Input : 1 -> 3 -> 2

  Return 1 -> 2 -> 3
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
  public ListNode insertionSortList(ListNode A) {
    ListNode head = new ListNode(Integer.MIN_VALUE);
    ListNode fast = A;

    while(fast != null) {
      // since we are going to change fast.next, we need to store it
      ListNode next = fast.next;

      ListNode prev = null;
      ListNode curr = head;
      // find node that is just above fast value
      while(curr != null && curr.val < fast.val) {
        prev = curr;
        curr = curr.next;
      }

      // set previous to fast, and have fast point to current
      prev.next = fast;
      fast.next = curr;

      fast = next;
    }

    return head.next;
  }
}
