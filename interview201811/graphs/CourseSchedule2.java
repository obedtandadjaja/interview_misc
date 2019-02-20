/*
  Difficulty: Medium

  There are a total of n courses you have to take, labeled from 0 to n-1.

  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

  Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

  There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

  Example 1:

  Input: 2, [[1,0]]
  Output: [0,1]
  Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
  course 0. So the correct course order is [0,1] .
  Example 2:

  Input: 4, [[1,0],[2,0],[3,1],[3,2]]
  Output: [0,1,2,3] or [0,2,1,3]
  Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
  courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
  So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
  Note:

  The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
  You may assume that there are no duplicate edges in the input prerequisites.
 */

class Solution {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    List<List<Integer>> graph = new ArrayList<>();

    for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
    for(int i = 0; i < prerequisites.length; i++) {
      graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    }

    boolean[] visitedNodes = new boolean[numCourses];
    boolean[] visitedEdges = new boolean[numCourses];

    List<Integer> result = new ArrayList<Integer>();

    for(int i = 0; i < numCourses; i++) {
      if(!visitedNodes[i]) {
        try {
          DFS(graph, visitedNodes, visitedEdges, i, result);
        } catch(GraphContainsCycleException e) {
          return new int[0];
        }
      }
    }

    int[] r = new int[result.size()];
    for(int i = 0; i < r.length; i++) r[i] = result.get(i);

    return r;
  }

  public void DFS(
    List<List<Integer>> graph,
    boolean[] visitedNodes,
    boolean[] visitedEdges,
    int curr,
    List<Integer> result
  ) throws GraphContainsCycleException {
    visitedNodes[curr] = true;
    visitedEdges[curr] = true;

    for(int next : graph.get(curr)) {
      if(visitedEdges[next]) throw new GraphContainsCycleException("cycles exist in the graph");
      if(visitedNodes[next]) continue;

      DFS(graph, visitedNodes, visitedEdges, next, result);
    }

    visitedEdges[curr] = false;

    result.add(curr);
  }

  private class GraphContainsCycleException extends Exception {
    public GraphContainsCycleException(String errorMessage) {
      super(errorMessage);
    }
  }
}
