import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Tree t = new Tree();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if("add".equals(op)) t.add(contact);
            else {
                System.out.println(t.find(contact));
            }
        }
    }

    public static class Node {
        HashMap<Character, Node> hash;
        int count;
        Node() {
            this.hash = new HashMap<Character, Node>();
            count = 0;
        }
    }

    public static class Tree {
        Node root;
        Tree() {
            root = new Node();
        }
        public void add(NString s) {
            HashMap<Character, Node> hash = root.hash;
            for(char c: s.toCharArray()) {
                if(!hash.containsKey(c)) {
                    hash.put(c, new Node());
                }
                hash.get(c).count++;
                hash = hash.get(c);
            }
        }
        public int find(String s) { return find(root, s); }
        public int find(Node root, String s) {
            if(s.length() == 0) {
                return root.count;
            } else if(root.hash.containsKey(s.charAt(0))) {
                return find(root.hash.get(s.charAt(0)), s.substring(1, s.length()));
            } else {
                return 0;
            }
        }
    }
}
