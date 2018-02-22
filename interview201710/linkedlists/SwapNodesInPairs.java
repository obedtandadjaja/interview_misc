/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode prev = head;
        ListNode curr = head;
        head = head.next;
        while(curr != null && curr.next != null) {
            prev.next = curr.next;
            ListNode temp = curr.next;
            curr.next = temp.next;
            temp.next = curr;
            
            prev = curr;
            curr = curr.next;
        }
        
        return head;
    }
}
