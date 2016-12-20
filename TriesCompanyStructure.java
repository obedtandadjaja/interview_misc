import java.util.*;
public class TriesCompanyStructure {
  public static void main(String[] args) {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    String[] list1 = {"BBB", "CCC", "EEE"};
    map.put("AAA", new ArrayList<String>(Arrays.asList(list1)));
    String[] list2 = {"DDD"};
    map.put("CCC", new ArrayList<String>(Arrays.asList(list2)));
    Tries t = new Tries();
    t.add(map);
    t.inorder();
  }
  public static class Node {
    HashMap<String, Node> children;
    String name;
    Node parent;
    public Node(String name) {
      this.name = name;
      this.children = new HashMap<String, Node>();
    }
  }
  public static class Tries {
    Node root;
    public Tries() {
      this.root = new Node("");
    }
    public void add(Map<String, List<String>> map) {
      for(Map.Entry<String, List<String>> entry : map.entrySet()) {
        addAt(entry.getKey(), entry.getValue());
      }
    }
    public void addAt(String name, List<String> children) {
      Node n = search(root, name);
      if(n == null) {
        add(root, name);
        n = root.children.get(name);
      }
      for(String child_name: children) {
        Node child = search(root, child_name);
        if(child == null) {
          add(n, child_name);
        } else {
          add(n, child);
        }
      }
    }
    public Node search(Node root, String name) {
      if(root == null) return null;
      else {
        if(root.children.containsKey(name)) {
          return root.children.get(name);
        } else {
          for(Node child : root.children.values()) {
            Node temp = search(child, name);
            if(temp != null) return temp;
          }
          return null;
        }
      }
    }
    public void add(Node root, String name) {
      Node child = new Node(name);
      child.parent = root;
      root.children.put(name, child);
    }
    public void add(Node root, Node child) {
      child.parent.children.remove(child.name);
      child.parent = root;
      root.children.put(child.name, child);
    }
    public void inorder() {
      for(Node child : root.children.values()) {
        inorder(child, "");
      }
    }
    public void inorder(Node root, String indent) {
      if(root != null) {
        System.out.println(indent+"- "+root.name);
        for(Node child : root.children.values()) {
          inorder(child, indent+"  ");
        }
      }
    }
  }
}