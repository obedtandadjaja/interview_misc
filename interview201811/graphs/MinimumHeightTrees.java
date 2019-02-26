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
  // fastest
  // approach: do BFS starting with the outermost layer where there is only 1 connection
  //           iterate level per level with BFS and decrementing the degree of the neighbors
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> myGraph = new ArrayList<List<Integer>>();
    List<Integer> result = new ArrayList<Integer>();

    if (n == 1) {
      result.add(0);
      return result;
    }

    int[] degree = new int[n];

    for(int i=0; i<n; i++) myGraph.add(new ArrayList<Integer>());
    for(int i=0; i<edges.length; i++) {
    	myGraph.get(edges[i][0]).add(edges[i][1]);
    	myGraph.get(edges[i][1]).add(edges[i][0]);
    	degree[edges[i][0]]++;
    	degree[edges[i][1]]++;
    }

    Queue<Integer> q = new ArrayDeque<Integer>();

    for(int i = 0; i < n; i++) {
    	if (degree[i] == 0)
    		return result;
    	else if (degree[i] == 1)
    		q.offer(i);
    }

    while(!q.isEmpty()) {
    	result = new ArrayList<Integer>();
    	int count = q.size();

    	for(int i = 0; i < count; i++){
    		int curr = q.poll();
    		result.add(curr);
    		degree[curr]--;

    		for(int j = 0; j < myGraph.get(curr).size(); j++) {
    			int next = myGraph.get(curr).get(k);

    			if (degree[next] == 0) continue;
    			if (degree[next] == 2) q.offer(next);

				  degree[next]--;
    		}
    	}
    }

    return result;
  }

  // slower
  // approach: use cached DFS to get the minimum depth per node
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<List<Integer>> graph = new ArrayList<>();

    for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
    for(int i = 0; i < edges.length; i++) {
      graph.get(edges[i][0]).add(edges[i][1]);
      graph.get(edges[i][1]).add(edges[i][0]);
    }

    HashMap<String, Integer> map = new HashMap<>();
    List<Integer> result = new ArrayList<Integer>();

    int minDepth = Integer.MAX_VALUE;
    for(int i = 0; i < n; i++) {
      int verticeDepth = getMaxDepth(graph, map, i, -1);
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

  public int getMaxDepth(List<List<Integer>> graph, HashMap<String, Integer> map, int curr, int prev) {
    if(graph.get(curr).size() == 0) return 1;
    if(map.containsKey(curr + " " + prev)) return map.get(curr + " " + prev);

    int maxDepth = 0;
    for(int i = 0; i < graph.get(curr).size(); i++) {
      if(graph.get(curr).get(i) == prev) continue;

      maxDepth = Math.max(maxDepth, getMaxDepth(graph, map, graph.get(curr).get(i), curr) + 1);
    }

    map.put(curr + " " + prev, maxDepth);

    return maxDepth;
  }
}
