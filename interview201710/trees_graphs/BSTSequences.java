package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class BSTSequences {
  public static void main(String[] args) {
    BinaryTree<Integer> bst = new BinaryTree<>();
    bst.add(5);
    bst.add(3);
    bst.add(7);
    bst.add(2);
    bst.add(4);
    bst.add(8);
    bst.add(6);

    ArrayList<LinkedList<Integer>> sequences = allSequences(bst.root);
    for(LinkedList<Integer> ll : sequences) {
      System.out.print("{");
      for(int i : ll) {
        System.out.print(i + ", ");
      }
      System.out.println("}");
    }
  }

  public static ArrayList<LinkedList<Integer>> allSequences(BSTNode<Integer> root) {
    ArrayList<LinkedList<Integer>> result = new ArrayList<>();

    if(root == null) {
      result.add(new LinkedList<Integer>());
      return result;
    }

    LinkedList<Integer> prefix = new LinkedList<>();
    prefix.add(root.data);

    ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);

    for(LinkedList<Integer> left : leftSeq) {
      for(LinkedList<Integer> right : rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
        weaveLists(left, right, weaved, prefix);
        result.addAll(weaved);
      }
    }

    return result;
  }

  public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second
    , ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
    if(first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = new LinkedList<Integer>();
      result.addAll(prefix);
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }

    int headFirst = first.removeByIndex(0);
    prefix.add(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeByIndex(prefix.size()-1);
    first.insert(0, headFirst);

    int headSecond = second.removeByIndex(0);
    prefix.add(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeByIndex(prefix.size()-1);
    second.insert(0, headSecond);
  }
}
