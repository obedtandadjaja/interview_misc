/*
  Difficulty: Medium

  In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

  Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

  Which nodes are eventually safe?  Return them as an array in sorted order.

  The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

  Example:
  Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
  Output: [2,4,5,6]
  Here is a diagram of the above graph.

  Illustration of graph

  Note:

  graph will have length at most 10000.
  The number of edges in the graph will not exceed 32000.
  Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */

class Solution {
  public List<Integer> eventualSafeNodes(int[][] graph) {
    List<Integer> result = new ArrayList<>();

    int[] visitedNode = new int[graph.length];
    boolean[] visitedEdge = new boolean[graph.length];

    List<Integer>[] g = new ArrayList[graph.length];

    for(int i = 0; i < graph.length; i++) g[i] = new ArrayList<>();
    for(int i = 0; i < graph.length; i++) {
      for(int j = 0; j < graph[i].length; j++) {
        g[i].add(graph[i][j]);
      }
    }

    for(int i = 0; i < graph.length; i++) {
      if(DFS(g, visitedNode, visitedEdge, i, result))
        result.add(i);
    }

    return result;
  }

  public boolean DFS(List<Integer>[] g, int[] visitedNode, boolean[] visitedEdge, int curr, List<Integer> result) {
    if(visitedNode[curr] > 0) return visitedNode[curr] == 1;

    visitedEdge[curr] = true;

    boolean returnValue = true;
    for(int next : g[curr]) {
      if(visitedEdge[next]) return false;

      returnValue &= DFS(g, visitedNode, visitedEdge, next, result);
    }

    visitedEdge[curr] = false;

    visitedNode[curr] = returnValue ? 1 : 2;
    return returnValue;
  }
}
