package interview201710.linkedlists;

import interview201710.DataStructures.*;

public class DeleteMiddleNode {
  public static void main(String[] args) {
    LinkedList<Integer> ll1 = new LinkedList<Integer>();
    ll1.add(1); ll1.add(1); ll1.add(3); ll1.add(5); ll1.add(5);
    System.out.println("LL: " + ll1.toString());
    System.out.println("Delete second node: " + deleteNode(ll1.head.next));
    System.out.println("LL: " + ll1.toString());
  }

  public static boolean deleteNode(LinkedListNode<Integer> nodeToRemove) {
    if(nodeToRemove == null || nodeToRemove.next == null) return false;
    nodeToRemove.data = (Integer)nodeToRemove.next.data;
    nodeToRemove.next = nodeToRemove.next.next;
    return true;
  }
}
