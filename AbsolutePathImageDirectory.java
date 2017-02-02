import java.util.*;
public class AbsolutePathImageDirectory {

  HashSet<Node> set;
  Node root;

  public static void main(String[] args) {
    AbsolutePathImageDirectory apid = new AbsolutePathImageDirectory();
    System.out.println("(1) First approach using Brute Force");
    apid.printAbsolutePath(new String[] {
      "/usr",
      "  /local",
      "    profile.jpg",
      "    /bin",
      "      config.txt",
      "      dest.png",
      "    /rbin",
      "  img.gif",
      "/sys",
      "  /re",
      "  /tmp",
      "    pic.jpg"
      }
    );
    System.out.println("\n(2) Second approach using Trees");
    apid.add(new String[] {
      "/usr",
      "  /local",
      "    profile.jpg",
      "    /bin",
      "      config.txt",
      "      dest.png",
      "    /rbin",
      "  img.gif",
      "/sys",
      "  /re",
      "  /tmp",
      "    pic.jpg"
      }
    );
    System.out.println(Arrays.toString(apid.getAbsolutePath()));
  }

  public void printAbsolutePath(String[] inputs) {
    for(int i = 0; i < inputs.length; i++) {
      if(isImage(inputs[i])) {
        int imageIndentCount = inputs[i].length()-inputs[i].replace(" ", "").length();
        StringBuilder sb = new StringBuilder();
        for(int j = i; j >= 0; j--) {
          if(inputs[j].contains("/")) {
            int indent = inputs[j].length()-inputs[j].replace(" ", "").length();
            if(indent+2 == imageIndentCount) {
              sb.insert(0,inputs[j].replace(" ",""));
              imageIndentCount -= 2;
            }
          }
        }
        System.out.println(sb.toString());
      }
    }
  }

  public AbsolutePathImageDirectory() {
    set = new HashSet<Node>();
    root = new Node(null, "");
  }

  public void add(String[] inputs) {
    // indent == 2 spaces
    Node current = root;
    int prevIndentCount = -2;
    for(int i = 0; i < inputs.length; i++) {
      int currentIndentCount = inputs[i].length()-inputs[i].replace(" ", "").length();
      int difference = prevIndentCount-currentIndentCount+2;
      System.out.println(inputs[i]+" "+currentIndentCount+" "+difference);
      if(difference > 0) {
        for(int j = 0; j < difference/2; j++) {
          current = current.parent;
        }
      }
      if(!isImage(inputs[i])) {
        Node n = new Node(current, inputs[i].replace(" ", ""));
        current.children.put(n.name, n);
        current = n;
      } else {
        set.add(current);
        currentIndentCount -= 2;
      }
      prevIndentCount = currentIndentCount;
    }
  }

  public String[] getAbsolutePath() {
    String[] result = new String[set.size()];
    int index = 0;
    for(Node n : set) {
      StringBuilder sb = new StringBuilder();
      while(n.parent != null) {
        sb.insert(0, n.name);
        n = n.parent;
      }
      result[index] = sb.toString();
      index++;
    }
    return result;
  }

  public boolean isImage(String s) {
    return s.contains(".png") ||
      s.contains(".gif") ||
      s.contains(".jpg") ||
      s.contains(".jpeg");
  }

  public class Node {
    HashMap<String, Node> children;
    Node parent;
    String name;
    public Node(Node parent, String name) {
      this.parent = parent;
      this.children = new HashMap<>();
      this.name = name;
    }
  }
}
