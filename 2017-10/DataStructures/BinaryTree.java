package DataStructures;

import DataStructures.abstracts.BinaryTreeAbstract;
import DataStructures.BSTNode;

import DataStructures.iterators.PreOrderTraversalIterator;
import DataStructures.iterators.PostOrderTraversalIterator;
import DataStructures.iterators.DFSIteratorBST;
import DataStructures.iterators.BFSIteratorBST;

import java.util.*;

public class BinaryTree<E extends Comparable<E>> extends BinaryTreeAbstract<E> {
  public void add(E data) {
    if(this.root == null) this.root = new BSTNode<E>(null, data, null);
    else add(data, this.root);
    this.size++;
  }

  // recursive add
  public void add(E data, BSTNode<E> root) {
    if(root.data.compareTo(data) < 0) {
      if(root.right == null) root.right = new BSTNode<E>(null, data, null, root);
      else add(data, root.right);
    } else {
      if(root.left == null) root.left = new BSTNode<E>(null, data, null, root);
      else add(data, root.left);
    }
  }

  public void delete(E data) {
    delete(data, this.root);
    this.size--;
  }

  // recursive delete
  public void delete(E data, BSTNode<E> root) {
    if(root.data.compareTo(data) < 0) {
      if(root.right != null) delete(data, root.right);
    } else if(root.data.compareTo(data) > 0) {
      if(root.left != null) delete(data, root.left);
    } else {
      if(root.left != null && root.right != null) {
        root.data = (E)nextInorderData(root.right);
        delete(root.data, root.right);
      } else {
        if(root.parent == null) {
          this.root = (root.right != null || root.left != null) ? root : null;
          if(this.root != null) this.root.parent = null;
        } else if(root.parent.left == root) {
          BSTNode<E> replacementNode = (root.left != null) ? root.left : root.right;
          root.parent.left = replacementNode;
          if(replacementNode != null) replacementNode.parent = root.parent;
        } else {
          BSTNode<E> replacementNode = (root.left != null) ? root.left : root.right;
          root.parent.right = replacementNode;
          if(replacementNode != null) replacementNode.parent = root.parent;
        }
      }
    }
  }

  public E nextInorderData(BSTNode<E> root) {
    if(root.left == null) return root.data;
    else return (E)nextInorderData(root.left);
  }

  public Iterator<E> iterator() {
    return new DFSIteratorBST(this.root);
  }

  public boolean lookup(E data) {
    return search(data, root) != null;
  }

  // recursive lookup
  public BSTNode<E> search(E data, BSTNode<E> root) {
    if(root == null) return null;
    else if(root.data.compareTo(data) == 0) return root;
    else if(root.data.compareTo(data) > 0) return search(data, root.right);
    else return search(data, root.left);
  }
}
