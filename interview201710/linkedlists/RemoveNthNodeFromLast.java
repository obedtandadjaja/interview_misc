/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.
Try to do this in one pass.
*/

public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class RemoveNthNodeFromLast {
    public static void main(String args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        removeNthFromEnd(head, 3);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode curr = temp;
        ListNode running = temp;

        for(int i = 0; i < n; i++)
            running = running.next;

        while(running != null && running.next != null) {
            running = running.next;
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return temp.next;

    }
}
