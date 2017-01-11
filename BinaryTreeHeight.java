public class BinaryTreeHeight {
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
    System.out.println(getHeight(n32));
  }

  public static int getHeight(Node root) {
    if(root == null) return -1;
    return Math.max(getHeight(root.left), getHeight(root.right))+1;
  }
}
