public class BinaryTreeToDoublyLinkedList {

  public static class Node {
    Node left, right;
    int val;
    public Node(Node left, int val, Node right) {
      this.left = left;
      this.val = val;
      this.right = right;
    }
  }

  public static Node prev = null;

  public static void convertToLinkedList(Node node) {
    if(node == null) return;
    if(node.left != null) convertToLinkedList(node.left);
    node.left = prev;
    if(prev != null) prev.right = node;
    prev = node;
    if(node.right != null) convertToLinkedList(node.right);
  }

  public static void main(String[] args) {
    Node n10 = new Node(
      new Node(
        new Node(null, 4, null),
        6,
        new Node(null, 8, null)
        ),
      10,
      new Node(
        new Node(null, 12, null),
        14,
        new Node(null, 16, null)
        )
      );
    convertToLinkedList(n10);
    while(n10.right != null) {
      n10 = n10.right;
    }
    while(n10 != null) {
      System.out.println(n10.val);
      n10 = n10.left;
    }
  }
}
