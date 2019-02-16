/*
  Difficulty: Medium

  Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    HashMap<UndirectedGraphNode, UndirectedGraphNode> lookup = new HashMap<>();

    return cloneGraphNode(node, lookup);
  }

  public UndirectedGraphNode cloneGraphNode(
    UndirectedGraphNode node,
    HashMap<UndirectedGraphNode, UndirectedGraphNode> lookup
  ) {
    if(node == null) return node;
    if(lookup.containsKey(node)) return lookup.get(node);

    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    lookup.put(node, newNode);

    for(UndirectedGraphNode neighbor : node.neighbors) {
      newNode.neighbors.add(cloneGraphNode(neighbor, lookup));
    }

    return newNode;
  }
}
