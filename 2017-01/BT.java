import java.util.*;
import java.util.LinkedList;

public class BT {

  private static class Node {
    int data;
    Node left, right;
    boolean visited;
    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
      this.visited = false;
    }
  }

  private static class Tree {
    Node root;
    Tree() {
      root = null;
    }

    /**
     * Insert
     */
    public void add(int data) {
      if(root == null) {
        root = new Node(data, null, null);
      } else {
        Node parent = null;
        Node curr = root;
        boolean isRight = false;
        while(curr != null) {
          parent = curr;
          if(data > curr.data) {
            curr = curr.right;
            isRight = true;
          } else {
            curr = curr.left;
            isRight = false;
          }
        }
        if(isRight)
          parent.right = new Node(data, null, null);
        else
          parent.left = new Node(data, null, null);
      }
    }
    public void addRecursive(int data) {
      root = addRecursive(data, root);
    }
    public Node addRecursive(int data, Node n) {
      if(n == null) {
        return new Node(data, null, null);
      } else {
        if(n.data < data) {
          n.right = addRecursive(data, n.right);
          return n;
        } else if(n.data > data) {
          n.left = addRecursive(data, n.left);
          return n;
        } else {
          return n;
        }
      }
    }

    /**
     * Traversal
     */
    public void inorder() {
      inorder(root);
    }
    public void inorder(Node curr) {
      if(curr != null) {
        inorder(curr.left);
        System.out.print(curr.data+", ");
        inorder(curr.right);
      }
    }
    public void preorder() {
      preorder(root);
    }
    public void preorder(Node curr) {
      if(curr != null) {
        System.out.print(curr.data+", ");
        preorder(curr.left);
        preorder(curr.right);
      }
    }
    public void postorder() {
      postorder(root);
    }
    public void postorder(Node curr) {
      if(curr != null) {
        postorder(curr.left);
        postorder(curr.right);
        System.out.print(curr.data+", ");
      }
    }

    /**
     * Search
     */
    public boolean search(int data) {
      return search(data, root);
    }
    public boolean search(int data, Node n) {
      if(n == null) {
        return false;
      } else if(n.data == data) {
        return true;
      } else {
        if(n.data < data) {
          return search(data, n.right);
        } else {
          return search(data, n.left);
        }
      }
    }
    public boolean DFS(int data) {
      if(root == null) return false;
      if(root.data == data) return true;
      Stack<Node> stack = new Stack<Node>();
      stack.push(root);
      root.visited = true;
      // System.out.println(root.data);
      while(!stack.empty()) {
        Node parent = stack.peek();
        Node child = getUnvisited(parent);
        if(child != null) {
          if(child.data == data) {
            return true;
          } else {
            stack.push(child);
            child.visited = true;
            // System.out.println(child.data);
          }
        } else {
          stack.pop();
        }
      }
      clearVisited();
      return false;
    }
    public boolean BFS(int data) {
      if(root == null) return false;
      if(root.data == data) return true;
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);
      root.visited = true;
      System.out.println(root.data);
      while(!q.isEmpty()) {
        Node parent = q.remove();
        Node child = null;
        while((child = getUnvisited(parent)) != null) {
          if(child.data == data) return true;
          System.out.println(child.data);
          child.visited = true;
          q.add(child);
        }
      }
      return false;
    }
    public Node getUnvisited(Node parent) {
      if(parent.left != null && !parent.left.visited) {
        return parent.left;
      } else if(parent.right != null && !parent.right.visited) {
        return parent.right;
      } else {
        return null;
      }
    }
    public void clearVisited() {
      clearVisited(root);
    }
    public void clearVisited(Node n) {
      if(n != null) {
        n.visited = false;
        clearVisited(n.left);
        clearVisited(n.right);
      }
    }
  }

  public static void main(String[] args) {
    Tree t = new Tree();
    t.addRecursive(5);
    t.addRecursive(3);
    t.addRecursive(7);
    t.addRecursive(4);
    t.addRecursive(6);
    t.inorder();
    System.out.println(t.BFS(6));
  }

}