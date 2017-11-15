package interview201710.DataStructures.abstracts;

import interview201710.DataStructures.*;

public class GraphAbstract<E> {
  public ArrayList<GraphNode<E>> nodes;

  public GraphAbstract() {
    nodes = new ArrayList<GraphNode<E>>();
  }

  public void addNode(E data) {
    this.nodes.add(new GraphNode<E>(data));
  }

  public void removeNode(int index) {
    GraphNode<E> nodeToBeRemoved = this.nodes.get(index);
    for(int i = 0; i < this.nodes.size(); i++)
      this.nodes.get(i).children.remove(nodeToBeRemoved);
    this.nodes.remove(index);
  }

  public void removeNode(E data) {
    GraphNode<E> nodeToBeRemoved = null;
    for(int i = 0; i < this.nodes.size(); i++)
      if(data == this.nodes.get(i).data) {
        nodeToBeRemoved = this.nodes.get(i);
        break;
      }

    for(int i = 0; i < this.nodes.size(); i++)
      this.nodes.get(i).children.remove(nodeToBeRemoved);

    this.nodes.remove(nodeToBeRemoved);
  }

  public void addVertex(int n1, int n2) {
    this.nodes.get(n1).addChild(this.nodes.get(n2));
  }

  public void addVertex(E n1, E n2) {
    GraphNode<E> node1 = null;
    GraphNode<E> node2 = null;

    for(int i = 0; i < this.nodes.size(); i++) {
      if(n1 == this.nodes.get(i).data) node1 = this.nodes.get(i);
      if(n2 == this.nodes.get(i).data) node2 = this.nodes.get(i);
    }

    node1.addChild(node2);
  }

  public void removeVertex(int n1, int n2) {
    this.nodes.get(n1).removeChild(this.nodes.get(n2));
  }

  public int size() {
    return this.nodes.size();
  }
}
