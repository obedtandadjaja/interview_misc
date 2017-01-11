import java.lang.Math;
public class ClosestNodeBinarySearchTree {
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
        new Node(null, 12, null),
        // null,
        15,
        new Node(null, 16, null)
        // null
        )
      );
    Node n32 = new Node(
      new Node(
        new Node(
          new Node(null, 14, null),
          21,
          null
          ),
        24,
        new Node(
          new Node(null, 25, null),
          28,
          new Node(null, 31, null)
          )
        ),
      32,
      new Node(
        new Node(
          null,
          36,
          new Node(null, 39, null)
          ),
        41,
        new Node(null,47,null)
        )
    );
    System.out.println(getClosestNode(n32, 29));
  }

  public static int getClosestNode(Node root, int n) {
    if(root.val == n) return root.val;

    int nextClosest;
    if(root.val > n) {
      if(root.left == null) return root.val;
      nextClosest = getClosestNode(root.left, n);
    } else {
      if(root.right == null) return root.val;
      nextClosest = getClosestNode(root.right, n);
    }

    if(Math.abs(n-nextClosest) > Math.abs(n-root.val)) {
      return root.val;
    } else {
      return nextClosest;
    }
  }
}
