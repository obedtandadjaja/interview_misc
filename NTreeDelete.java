import java.util.*;

public class NTreeDelete {

  public static void main(String[] args) {
    Node t10 = new Node(); t10.val = 10;
    Node t9 = new Node(); t9.val = 9; t9.children = new Node[] { t10 };
    Node t8 = new Node(); t8.val = 8;
    Node t7 = new Node(); t7.val = 7;

    Node t6 = new Node(); t6.val = 6; t6.children = new Node[] { t9 };
    Node t5 = new Node(); t5.val = 5; t5.children = new Node[] { t7, t8 };

    Node t4 = new Node(); t4.val = 4; t4.children = new Node[] { t5, t6 };
    Node t3 = new Node(); t3.val = 3;
    Node t2 = new Node(); t2.val = 2;

    Node t1 = new Node(); t1.val = 1; t1.children = new Node[] { t2, t3, t4 };

    HashSet<Node> set = new HashSet<Node>();
    set.add(t4); set.add(t5); set.add(t9);

    System.out.println(delete(t1, set));
  }

  public static List<Node> delete(Node root, HashSet<Node> set) {
    List<Node> result = new ArrayList<Node>();
    if(set == null || set.isEmpty()) {
      result.add(root);
      return result;
    }

    doDelete(root, set, result, true);
    return result;
  }
  public static Node doDelete(Node root, HashSet<Node> set, List<Node> result, boolean isOrphan) {
    boolean childrenAreOrphans = false;
    childrenAreOrphans = set.remove(root);

    if(isOrphan && !childrenAreOrphans) {
      result.add(root);
    }

    if(!childrenAreOrphans && set.isEmpty()) {
      return root;
    }

    if(root.children != null) {
      for(int i = 0; i < root.children.length; i++) {
        root.children[i] = doDelete(root.children[i], set, result, childrenAreOrphans);
      }
    }

    return childrenAreOrphans ? null : root;
  }

  public static class Node {
    Node[] children;
    int val;
    public Node(int val, Node[] children) {
      this.val = val;
      this.children = children;
    }
    public Node(){};
  }

}
