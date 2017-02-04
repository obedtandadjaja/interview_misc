import java.util.*;
import java.lang.Math;
public class BTLongestConsecutivePath {
  public static void main(String[] args) {
    BT t = new BT();
    t.add(6);
    t.add(2);
    t.add(1);
    t.add(0);
    t.add(4);
    t.add(3);
    t.add(5);
    t.postorder();
    //                  6
    //       2
    //    1     3
    // 0           4
    //                5
    // System.out.println(t.searchLongestPath());
  }

  public static class BT {
    Node root;
    ArrayList<Integer> array;
    public BT() {
      this.root = null;
      this.array = new ArrayList<Integer>();
    }
    public void add(int val) {
      root = add(root, val);
    }
    public Node add(Node root, int val) {
      if(root == null) return new Node(val, null, null);
      else {
        if(root.val < val) {
          root.right = add(root.right, val);
          return root;
        } else if(root.val > val) {
          root.left = add(root.left, val);
          return root;
        } else {
          return root;
        }
      }
    }
    public void inorder() { inorder(root); }
    public void inorder(Node root) {
      if(root != null) {
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
      }
    }
    public void postorder() { postorder(root); }
    public void postorder(Node root) {
      if(root != null) {
        postorder(root.left);
        postorder(root.right);
        array.add(root.val);
        System.out.println(root.val);
      }
    }
    public ArrayList<String> searchConsecutive() {
      ArrayList<String> consecutive = new ArrayList<String>();
      String str = "";
      for(int i = 0; i < array.size()-1; i++) {
        if(Math.abs(array.get(i)-array.get(i+1)) == 1) {
          if(str.length() == 0) {
            str += array.get(i)+","+array.get(i+1)+",";
          } else {
            str += array.get(i+1)+",";
          }
        } else {
          if(str.length() != 0) consecutive.add(str);
          str = "";
        }
      }
      return consecutive;
    }
    public String searchLongestPath() {
      ArrayList<String> consecutive = searchConsecutive();
      int original_size = consecutive.size();
      for(int i = 0; i < original_size; i++) {
        for(int j = 0; j < original_size; j++) {
          if(i != j) {
            String str1 = consecutive.get(i);
            String str2 = consecutive.get(j);
            if(Math.abs(str1.charAt(str1.length()-2)-str2.charAt(str2.length()-2)) == 1) {
              for(int x = str2.length()-2; x >= 0; x-=2) {
                str1 += str2.charAt(x)+",";
              }
              consecutive.add(str1);
            }
          }
        }
      }
      int length = 0;
      int index = -1;
      for(int i = 0; i < consecutive.size(); i++) {
        if(consecutive.get(i).length() > length) {
          length = consecutive.get(i).length();
          index = i;
        }
      }
      return index == -1 ? "" : consecutive.get(index);
    }
  }

  public static class Node {
    Node left, right;
    int val;
    public Node(int val, Node left, Node right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
