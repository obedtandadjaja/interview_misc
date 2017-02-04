import java.util.*;
public class BTLongestConsecutivePathRecursive {

  public static void main(String[] args) {
    Tree t = new Tree();

  }

  public static class Tree {
    Node root;
    public Tree() {
      root = null;
    }

    public void add(int i) {
      if(root == null) root = new Node(null, i, null);
      else add(root, i);
    }
    public Node add(Node current, int i) {
      if(current == null) return new Node(null, i, null);
      if(i < current.val) {
        current.left = add(current.left, i);
      } else if(i > current.val) {
        current.right = add(current.right, i);
      }
      return current;
    }
    public ArrayList<Integer> getConsecutivePath(Node current, ArrayList<Integer> array) {

    }
  }

  public static class Node {
    int val;
    Node left, right;
    public Node(Node left, int val, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

}
