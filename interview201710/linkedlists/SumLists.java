package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class SumLists {
  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(1); ll1.add(1); ll1.add(3); ll1.add(5); ll1.add(8);
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(1); ll1.add(1); ll1.add(9); ll1.add(5); ll1.add(9);
    System.out.println("LL1: " + ll1.toString());
    System.out.println("LL2: " + ll1.toString());
    LinkedList<Integer> result = new LinkedList<Integer>();
    result.head = sumLists(ll1.head, ll2.head, 0);
    System.out.println("result: " + result.toString());
  }

  public LinkedListNode<Integer> sumLists(LinkedListNode<Integer> n1, LinkedListNode<Integer> n2, int extra) {
    if(n1 == null && n2 == null) return null;
    LinkedListNode<Integer> n = new LinkedListNode<Integer>();
    n.data += n1 != null ? n1.data : 0;
    n.data += n2 != null ? n2.data : 0;
    n.data += extra;
    n.next = sumLists(n1 != null ? n1.next : null,
                      n2 != null ? n2.next : null,
                      n.data % 10);
    return n;
  }
}
