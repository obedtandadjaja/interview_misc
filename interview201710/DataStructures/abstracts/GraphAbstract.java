package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.*;

public class GraphAbstract<E> {
  ArrayList<GraphNode<E>> nodes;

  public GraphAbstract() {
    nodes = new ArrayList<GraphNode<E>>();
  }

  public void addNode(E data) {
    this.nodes.add(new GraphNode<E>(data));
  }

  public void addVertex(int n1, int n2) {
    this.nodes.get(n1).addChild(this.nodes.get(n2));
  }

  public void removeVertex(int n1, int n2) {
    this.nodes.get(n1).removeChild(this.nodes.get(n2));
  }

  public int size() {
    return this.nodes.size();
  }
}
