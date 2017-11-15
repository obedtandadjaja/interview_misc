package interview201710.trees_graphs;

import interview201710.DataStructures.*;
import java.lang.StringBuilder;

public class BuildOrder {
  public static void main(String[] args) {
    String[][] dependencies = new String[][] {
      new String[] { "a", "d" },
      new String[] { "f", "b" },
      new String[] { "b", "d" },
      new String[] { "f", "a" },
      new String[] { "d", "c" },
    };
    String[] builds = new String[] { "a", "b", "c", "d", "e", "f" };

    System.out.println(getBuildOrder(builds, dependencies));
  }

  public static String getBuildOrder(String[] builds, String[][] dependencies) {
    Graph<String> g = setupGraph(builds, dependencies);
    StringBuilder sb = new StringBuilder();

    while(g.nodes.size() > 0)
      iterateGraphNodeDependency(g.nodes.get(0), g, sb);

    return sb.toString();
  }

  public static void iterateGraphNodeDependency(GraphNode<String> node, Graph<String> g, StringBuilder sb) {
    if(node == null) return;
    if(node.children.size() == 0) {
      sb.append(node.data + ", ");
      g.removeNode(node.data);
    } else {
        for(int i = 0; i < node.children.size(); i++)
          iterateGraphNodeDependency(node.children.get(0), g, sb);
        sb.append(node.data + ", ");
        g.removeNode(node.data);
    }
  }

  public static Graph<String> setupGraph(String[] builds, String[][] dependencies) {
    Graph<String> g = new Graph<>();
    for(String str : builds)
      g.addNode(str);

    try {
      for(String[] dependency : dependencies)
        g.addVertex(dependency[1], dependency[0]);
    } catch(Exception e) {
      System.out.println(e.toString());
    }

    return g;
  }
}
