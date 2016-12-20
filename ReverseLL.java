
public class ReverseLL {
  private static class Node {
    int data;
    Node next;
    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static class LinkedList {
    Node head;
    LinkedList() {
      head = null;
    }

    public void add(int data) {
      if(head == null) head = new Node(data, null);
      else {
        Node curr = head;
        while(curr.next != null) {
          curr = curr.next;
        }
        curr.next = new Node(data, null);
      }
    }

    public void addAt(int data, int index) {
      if(index == 0) head = new Node(data, head);
      else {
        int i = 0;
        Node curr = head;
        while(curr.next != null && i < index-1) {
          curr = curr.next;
          i++;
        }
        if(i == index-1) {
          curr.next = new Node(data, curr.next);
        } else {
          System.out.println("Invalid index "+i);
        }
      }
    }
    /**
     * essentially we make a new list kinda
     */
    public void reverse() {
      Node new_head = null;
      Node curr = head;
      while(curr != null) {
        new_head = new Node(curr.data, new_head);
        curr = curr.next;
      }
      head = new_head;
    }

    public void reverseBest() {
      Node prev = null;
      Node curr = head;
      Node temp;
      while(curr != null) {
        temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
      }
      head = prev;
    }

    public void print() {
      if(head != null) {
        Node curr = head;
        while(curr != null) {
          System.out.print(curr.data+", ");
          curr = curr.next;
        }
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    LinkedList ll = new LinkedList();
    ll.add(1);
    ll.add(3);
    ll.add(4);
    ll.addAt(2,1);
    ll.addAt(5,4);
    ll.reverseBest();
    ll.print();
  }
}