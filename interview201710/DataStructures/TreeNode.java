package interview201710.DataStructures;

import interview201710.DataStructures.abstracts.NodeAbstract;
import interview201710.DataStructures.LinkedList;

public class TreeNode<E> extends NodeAbstract<E> {
  public LinkedList<TreeNode<E>> children;

  public TreeNode(E data) {
    this.data = data;
    this.children = new LinkedList<TreeNode<E>>();
  }

  public void addChild(E data) {
    this.children.add(new TreeNode<E>(data));
  }

  public void deleteChild(E data) {
    for(int i = 0; i < this.children.size(); i++)
      if(this.children.get(i).equals(data)) this.children.removeByIndex(i);
  }
}
