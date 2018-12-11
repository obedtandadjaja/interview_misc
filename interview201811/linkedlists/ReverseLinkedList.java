/*
	Difficulty: Easy
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.

	Reverse a singly linked list.

	Example:

	Input: 1->2->3->4->5->NULL
	Output: 5->4->3->2->1->NULL
	Follow up:

	A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if(head == null || head.next == null) return head;

    ListNode new_head = head;
    while(head.next != null) {
      ListNode temp = head.next;
      head.next = temp.next;
      temp.next = new_head;
      new_head = temp;
    }

    return new_head;
  }

  public ListNode reverseList2(ListNode head) {
    if(head == null || head.next == null) return head;

    ListNode temp = reverseList2(head.next);
    head.next.next = head;
    head.next = null;
    return temp;
  }
}
