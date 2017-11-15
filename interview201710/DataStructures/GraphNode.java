package interview201710.DataStructures;

import interview201710.DataStructures.*;
import interview201710.DataStructures.abstracts.*;

public class GraphNode<E> extends NodeAbstract<E> {
  public ArrayList<GraphNode<E>> children;

  public GraphNode(E data) {
    this.children = new ArrayList<GraphNode<E>>();
    this.data = data;
  }

  public GraphNode(E data, ArrayList<GraphNode<E>> children) {
    this.data = data;
    this.children = children;
  }

  public void addChild(GraphNode<E> child) {
    this.children.add(child);
  }

  public void addNewChild(E data) {
    this.children.add(new GraphNode<E>(data));
  }

  public void removeChild(GraphNode<E> child) {
    this.children.remove(child);
  }
}
