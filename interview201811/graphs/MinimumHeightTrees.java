/*
  Difficulty: Medium

  For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

  Format
  The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

  You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

  Example 1 :

  Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

  0
  |
  1
  / \
  2   3

  Output: [1]
  Example 2 :

  Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

  0  1  2
  \ | /
  3
  |
  4
  |
  5

  Output: [3, 4]
  Note:

  According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
  The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 */
class Solution {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();

    for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
    for(int i = 0; i < edges.length; i++) {
      graph.get(edges[i][0]).add(edges[i][1]);
      graph.get(edges[i][1]).add(edges[i][0]);
    }

    List<Integer> result = new ArrayList<Integer>();
    int minDepth = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      int verticeDepth = getMaxDepth(graph, i, -1);
      if(minDepth == verticeDepth) {
        result.add(i);
      } else if(minDepth > verticeDepth) {
        result.clear();
        result.add(i);
      }
      minDepth = Math.min(minDepth, verticeDepth);
    }

    return result;
  }

  public int getMaxDepth(List<List<Integer>> graph, int curr, int prev) {
    if(graph.get(curr).size() == 0) return 1;

    int maxDepth = Integer.MIN_VALUE;
    for(int i = 0; i < graph.get(curr).size(); i++) {
      if(graph.get(curr).get(i) == prev) continue;

      maxDepth = Math.max(maxDepth, getMaxDepth(graph, graph.get(curr).get(i), curr) + 1);
    }

    return maxDepth;
  }
}
