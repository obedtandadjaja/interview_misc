package interview201710.trees_graphs;

import interview201710.DataStructures.*;
import java.util.HashSet;

public class RouteBetweenNodes {
  public static void main(String[] args) {
    Graph<Integer> g = new Graph<Integer>();

    try {
      g.addNode(1);
      g.addNode(2);
      g.addNode(3);
      g.addNode(4);

      g.addVertex(0,1);
      g.addVertex(0,2);
      g.addVertex(0,3);

      g.addVertex(1, 0);
      g.addVertex(1, 2);

      g.addVertex(2, 0);
      g.addVertex(2, 3);

      System.out.println(hasRouteBetweenNodes(g.nodes.get(0), g.nodes.get(3)));
      System.out.println(hasRouteBetweenNodes(g.nodes.get(3), g.nodes.get(0)));
    } catch(Exception ex) {
      System.out.println(ex.toString());
    }
  }

  public static boolean hasRouteBetweenNodes(GraphNode<Integer> n1, GraphNode<Integer> n2) {
    return BFS(n1, n2);
  }

  public static boolean BFS(GraphNode<Integer> n1, GraphNode<Integer> n2) {
    if(n1 == n2) return true;

    HashSet<GraphNode<Integer>> visited = new HashSet<GraphNode<Integer>>();
    Queue<GraphNode<Integer>> q = new Queue<GraphNode<Integer>>();
    q.add(n1);
    visited.add(n1);
    while(q.size() > 0) {
      GraphNode<Integer> curr = q.poll();
      if(curr == n2) return true;
      for(int i = 0; i < curr.children.size(); i++) {
        try {
          if(!visited.contains(curr.children.get(i))) {
            q.add(curr.children.get(i));
            visited.add(curr.children.get(i));
          }
        } catch(Exception e) {}
      }
    }

    return false;
  }
}
