import java.util.*;

public class PriorityLinkedList<E extends Comparable<E>> {

  Node<E> root;

  public static void main(String[] args) {
    PriorityLinkedList<Integer> pll = new PriorityLinkedList<Integer>();
    pll.add(1);
    pll.add(3);
    pll.add(5);
    pll.add(4);
    pll.add(7);
    pll.add(8);
    pll.add(9);
    pll.add(10);
    pll.add(11);
    pll.remove(3);
    System.out.println(pll.toString());
    pll.reverse2();
    System.out.println(pll.toString());
  }

  public PriorityLinkedList() {
    this.root = null;
  }

  public void add(E data) {
    if(root == null) {
      root = new Node<E>(data, null);
    } else {
      Node<E> parent = null;
      Node<E> current = root;
      while(current != null) {
        if(current.data.compareTo(data) > 0) {
          if(parent == null) {
            parent = new Node<E>(data, current);
            root = parent;
          } else {
            parent.next = new Node<E>(data, current);
          }
          return;
        }
        parent = current;
        current = current.next;
      }
      parent.next = new Node<E>(data, null);
    }
  }

  public void remove(E data) {
    if(root == null) {
      return;
    } else {
      Node<E> parent = null;
      Node<E> current = root;
      while(current != null) {
        if(current.data.compareTo(data) == 0) {
          if(parent == null) root = root.next;
          else parent.next = current.next;
          return;
        }
        parent = current;
        current = current.next;
      }
    }
  }

  public void reverse() {
    Node<E> newRoot = null;
    Node<E> current = root;
    while(current != null) {
      newRoot = new Node<E>(current.data, newRoot);
      current = current.next;
    }
    root = newRoot;
  }

  public void reverse2() {
    Node<E> prev = root;
    Node<E> current = root.next;
    while(current != null) {
      prev.next = current.next;
      current.next = root;
      root = current;
      current = prev.next;
    }
  }

  public String toString() {
    if(root == null) {
      return "Empty";
    } else {
      Node<E> current = root;
      StringBuilder sb = new StringBuilder();
      while(current != null) {
        sb.append(current.data);
        sb.append(", ");
        current = current.next;
      }
      return sb.toString();
    }
  }

  public class Node<E extends Comparable<E>> {
    E data;
    Node<E> next;
    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
}
