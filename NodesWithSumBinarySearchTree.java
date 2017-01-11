import java.util.*;
public class NodesWithSumBinarySearchTree {

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
    ArrayList<Integer> array = new ArrayList<>();
    inorder(n32, array);
    System.out.println(sumExists(array, 66));
  }

  // O(n) - better than Binary Search which is O(n log n)
  public static boolean sumExists(ArrayList<Integer> array, int sum) {
    int start = 0;
    int end = array.size()-1;
    while(start < end) {
      int ourSum = array.get(start)+array.get(end);
      if(sum == ourSum) {
        return true;
      } else if(sum < ourSum) {
        end--;
      } else {
        start++;
      }
    }
    return false;
  }

  public static void inorder(Node root, ArrayList<Integer> array) {
    if(root != null) {
      inorder(root.left, array);
      array.add(root.val);
      inorder(root.right, array);
    }
  }
}
