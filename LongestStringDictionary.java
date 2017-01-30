import java.io.*;
import java.util.*;

public class LongestStringDictionary {

  public static void main(String[] args) {
    Trie t = new Trie();
    t.add("apple");
    t.add("ale");
    t.add("monkey");
    t.add("plea");
    System.out.println(t.toString());
  }

  public static class Trie {
    Node root;
    public Trie() {
      this.root = new Node();
    }
    public void add(String s) {
      Node current = root;
      for(int i = 0; i < s.length(); i++) {
        add(current, s.charAt(i));
        current = current.children.get(s.charAt(i));
      }
    }
    public void add(Node root, char c) {
      if(root == null) return;
      if(!root.children.containsKey(c)) root.children.put(c, new Node());
    }
    public String findLongestString(String s) {
      Node current = root;
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < s.length(); i++) {
        if(current.children.containsKey(s.charAt(i))) {
        }
      }
    }
    public String toString() {
      StringBuilder sb = new StringBuilder();
      Stack<Node> stack = new Stack<Node>();
      HashSet<Node> visited = new HashSet<Node>();
      stack.push(root);
      while(!stack.isEmpty()) {
        Node current = stack.peek();
        Node n = null;
        for(char c : current.children.keySet()) {
          if(visited.contains(current.children.get(c))) {
            continue;
          } else {
            n = current.children.get(c);
            visited.add(n);
            sb.append(c);
            break;
          }
        }
        if(n != null) {
          stack.push(n);
        } else {
          stack.pop();
        }
      }
      return sb.toString();
    }
  }

  public static class Node {
    HashMap<Character, Node> children;
    public Node() {
      this.children = new HashMap<>();
    }
  }

}
