public class LinkedList {
  int vertex;
  Node head;
  int total_weight;
  int from_vertex;
  int length;
  boolean visited;

  public LinkedList(int vertex) {
    this.vertex = vertex;
    this.head = null;
    this.total_weight = Integer.MAX_VALUE;
    this.from_vertex = -1;
    this.length = 0;
    this.visited = false;
  }

  public void add(int vertex, int weight) {
    if(head == null) {
      head = new Node(vertex, weight, null);
    } else {
      Node curr = head;
      while(curr.next != null) {
        curr = curr.next;
      }
      curr.next = new Node(vertex, weight, null);
    }
    length++;
  }

  public Node[] getNodes() {
    if(head == null) {
      return null;
    }
    int index = 0;
    Node[] array = new Node[this.length];
    Node curr = head;
    while(curr != null) {
      array[index] = curr;
      index++;
      curr = curr.next;
    }
    return array;
  }
}