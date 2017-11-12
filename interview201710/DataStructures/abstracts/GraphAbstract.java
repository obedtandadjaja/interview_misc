package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.*;

import java.lang.*;

public class GraphAbstract<E> {
  public ArrayList<GraphNode<E>> nodes;

  public GraphAbstract() {
    nodes = new ArrayList<GraphNode<E>>();
  }

  public void addNode(E data) {
    this.nodes.add(new GraphNode<E>(data));
  }

  public void removeNode(int index) throws Exception {
    this.nodes.remove(index);
  }

  public void addVertex(int n1, int n2) throws Exception {
    this.nodes.get(n1).addChild(this.nodes.get(n2));
  }

  public void removeVertex(int n1, int n2) throws Exception {
    this.nodes.get(n1).removeChild(this.nodes.get(n2));
  }

  public int size() {
    return this.nodes.size();
  }
}
