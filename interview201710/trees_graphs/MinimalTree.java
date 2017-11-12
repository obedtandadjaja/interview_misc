package interview201710.trees_graphs;

import interview201710.DataStructures.*;

public class MinimalTree {
  BinaryTree<Integer> bst;

  public static void main(String[] args) {
    MinimalTree mBST = new MinimalTree();
    mBST.populateBST(new int[] {1,2,3,4,5,6,7,8,9,10}, 0, 9);
    System.out.println(mBST.toString());
  }

  public MinimalTree() {
    this.bst = new BinaryTree<Integer>();
  }

  public String toString() {
    return this.bst.toString();
  }

  public void populateBST(int[] array, int start, int end) {
    if(start > end) return;

    int middle = (start+end)/2;
    this.bst.add(array[middle]);
    populateBST(array, start, middle-1);
    populateBST(array, middle+1, end);
  }
}
