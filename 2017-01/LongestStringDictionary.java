import java.io.*;
import java.util.*;

public class LongestStringDictionary {
  public static void main(String[] args) {
    // first approach
    Trie t = new Trie();
    t.add("apple");
    t.add("ale");
    t.add("monkey");
    t.add("plea");
    System.out.println("first approach: "+t.findLongestString("abpcplea"));
    // second approach
    Dictionary d = new Dictionary();
    d.add("apple");
    d.add("ale");
    d.add("monkey");
    d.add("plea");
    System.out.println("second approach: "+d.findLongestString("abpcplea"));
  }

  // first approach using Tries - Not very efficient
  // time complexity: O(w*m*n^2) (i.e. O(n^2)) where w is the length of the longest word and
  // m is the length of the dictionary and n is the length of the query string
  // space complexity: O(w*m)
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
      String currentLongest = "";
      int index = 0;
      while(index+currentLongest.length() < s.length()) {
        Node current = root;
        StringBuilder sb = new StringBuilder();
        for(int i = index; i < s.length(); i++) {
          if(current.children.containsKey(s.charAt(i))) {
            sb.append(s.charAt(i));
            current = current.children.get(s.charAt(i));
          }
        }
        if(sb.length() > currentLongest.length()) {
          currentLongest = sb.toString();
        }
        index++;
      }
      return currentLongest;
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

  // second approach
  // time complexity: same as first approach
  // space complexity: O(1)
  public static class Dictionary {
    HashSet<String> dict;
    public Dictionary() {
      this.dict = new HashSet<>();
    }
    public void add(String s) {
      dict.add(s);
    }
    public String toString() {
      return dict.toString();
    }
    public String findLongestString(String s) {
      String currentLongest = "";
      for(String word : dict) {
        if(isStringContained(s, word)) {
          if(currentLongest.length() < word.length()) {
            currentLongest = word;
          }
        }
      }
      return currentLongest;
    }
    public boolean isStringContained(String query, String word) {
      if(word.length() > query.length()) return false;
      if(word.length() == query.length() && !word.equals(query)) return false;
      int wordIndex = 0;
      int queryIndex = 0;
      while(queryIndex < query.length() && wordIndex < word.length()) {
        if(query.charAt(queryIndex) == word.charAt(wordIndex)) {
          wordIndex++;
        }
        queryIndex++;
      }
      if(wordIndex == word.length()) return true;
      else return false;
    }
  }

}
