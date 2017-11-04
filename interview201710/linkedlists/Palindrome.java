package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class Palindrome {
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);
    list.add(1);

    System.out.println("1->2->3->2->1: " + isPalindrome(list.head));
    System.out.println("1->2->3->2->1 recurse: " + isPalindromeRecurse(list.head));

    list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(1);

    System.out.println("1->2->3->4->1: " + isPalindrome(list.head));
    System.out.println("1->2->3->4->1 recurse: " + isPalindromeRecurse(list.head));
  }

  public static boolean isPalindrome(LinkedListNode<Integer> head) {
    if(head == null) return true;

    Stack<Integer> s = new Stack<Integer>();
    LinkedListNode<Integer> curr = head;
    LinkedListNode<Integer> runner = head;
    while(runner != null && runner.next != null) {
      s.push(curr.data);
      curr = curr.next;
      runner = runner.next.next;
    }

    if(runner != null) curr = curr.next;

    while(s.size() > 0) {
      if(s.pop() != curr.data) {
        return false;
      }
      curr = curr.next;
    }
    return true;
  }

  public static boolean isPalindromeRecurse(LinkedListNode<Integer> head) {
    int length = linkedListLength(head);
    return isPalindromeRecurseHelper(head, length).isPalindrome;
  }

  public static int linkedListLength(LinkedListNode<Integer> head) {
    int length = 0;
    LinkedListNode<Integer> curr = head;
    while(curr != null) {
      length++;
      curr = curr.next;
    }

    return length;
  }

  public static PalindromeRecurseResult isPalindromeRecurseHelper(LinkedListNode<Integer> head, int length) {
    if(length == 0) return new PalindromeRecurseResult(head, true);
    else if(length == 1) return new PalindromeRecurseResult(head.next, true);

    int currentData = head.data;
    PalindromeRecurseResult result = isPalindromeRecurseHelper(head.next, length-2);
    result.isPalindrome &= currentData == result.n.data;
    result.n = result.n.next;

    return result;
  }

  public static class PalindromeRecurseResult {
    LinkedListNode<Integer> n;
    boolean isPalindrome;
    public PalindromeRecurseResult(LinkedListNode<Integer> n, boolean isPalindrome) {
      this.n = n;
      this.isPalindrome = isPalindrome;
    }
  }
}
