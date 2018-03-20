/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Palindrome2 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        
        Stack<ListNode> s = new Stack<>();
        ListNode runner = head;
        int length = 0;
        
        while(runner != null) {
            s.push(runner);
            runner = runner.next;
            length++;
        }
        
        length /= 2;
        
        while(!s.isEmpty() && length > 0) {
            if(head.val != s.peek().val) return false;
            head = head.next;
            s.pop();
        }
        
        return true;
    
    public boolean isPalindrome2(ListNode head) {
        if(head == null) return true;
        
        ListNode newHead = head;
        ListNode fast = head;
        ListNode runner = head;
        
        while(runner != null && runner.next != null) {
            runner = runner.next.next;
            if(runner == null) break;
            
            // reverse
            ListNode temp = fast.next.next;
            fast.next.next = newHead;
            newHead = fast.next;
            fast.next = temp;
        }
        
        fast = fast.next;
        if(runner != null) newHead = newHead.next;
        
        while(newHead != null && fast != null) {
            if(newHead.val != fast.val) return false;
            newHead = newHead.next;
            fast = fast.next;
            if(newHead == fast) break;
        }
        
        return true;
    }
}
