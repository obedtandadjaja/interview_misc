import java.util.*;
public class BinaryTreeSpecifiedSumPath {

  public static class Node {
    Node left, right;
    int val;
    public Node(Node left, int val, Node right) {
      this.left = left;
      this.val = val;
      this.right = right;
    }
  }

  public static int getPath(Node root, int n, StringBuilder s) {
    if(n < 0 || root == null) return 0;
    if(root.left == null && root.right == null && n-root.val == 0) {
      System.out.println(s.toString()+root.val);
      return 1;
    }
    int ori_length = s.length();
    int count = getPath(root.left, n-root.val, s.append(root.val));
    if(ori_length >= 0) s.setLength(ori_length);
    count += getPath(root.right, n-root.val, s.append(root.val));
    if(ori_length >= 0) s.setLength(ori_length);
    return count;
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
    System.out.println(getPath(n10,22,new StringBuilder()));
  }
}
