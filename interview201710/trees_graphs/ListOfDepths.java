package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class ListOfDepths {
  public static void main(String[] args) {
    BinaryTree<Integer> bst = new BinaryTree<Integer>();
    bst.add(5);
    bst.add(3);
    bst.add(7);
    bst.add(2);
    bst.add(1);
    bst.add(4);
    bst.add(9);
    bst.add(10);
    bst.add(8);
    bst.add(6);

    ArrayList<LinkedList<Integer>> lls = listDepths(bst);
    for(int i = 0; i < lls.size(); i++) {
      try {
        System.out.println(lls.get(i).toString());
      } catch(Exception e) {}
    }
  }

  public static ArrayList<LinkedList<Integer>> listDepths(BinaryTree<Integer> bst) {
    ArrayList<LinkedList<Integer>> lls = new ArrayList<>();

    Queue<BSTNode<Integer>> q = new Queue<>();
    q.add(bst.root);

    int current_size = 0;
    while(q.size() > 0) {
      current_size = q.size();
      LinkedList<Integer> ll = new LinkedList<>();
      for(int i = 0; i < current_size; i++) {
        BSTNode<Integer> n = q.poll();
        if(n != null) {
          ll.add(n.data);
          if(n.left != null) q.add(n.left);
          if(n.right != null) q.add(n.right);
        }
      }
      lls.add(ll);
    }

    return lls;
  }
}
