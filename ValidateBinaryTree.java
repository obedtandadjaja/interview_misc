import java.lang.Math;

public class ValidateBinaryTree {

  public static class Node {
    Node left, right;
    int val;
    public Node(Node left, int val, Node right) {
      this.left = left;
      this.val = val;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    Node n10 = new Node(
      new Node(
        new Node(null, 4, null),
        5,
        new Node(null, 7, null)
        ),
      10,
      new Node(
        // new Node(null, 12, null),
        null,
        12,
        // new Node(null, 16, null)
        null
        )
      );
    System.out.println(getHeight(n10));
  }

  public static int getHeight(Node root) {
    if(root == null) return -1;

    int left = getHeight(root.left)+1;
    if(left == Integer.MIN_VALUE) return left;

    int right = getHeight(root.right)+1;
    if(right == Integer.MIN_VALUE) return right;

    if(Math.abs(left-right) <= 1) {
      return Math.max(left, right);
    } else {
      return Integer.MIN_VALUE;
    }
  }
}
