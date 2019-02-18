/*
  Difficulty: Medium

  Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

  Example:
  Given a / b = 2.0, b / c = 3.0.
  queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
  return [6.0, 0.5, -1.0, 1.0, -1.0 ].

  The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

  According to the example above:

  equations = [ ["a", "b"], ["b", "c"] ],
  values = [2.0, 3.0],
  queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
  The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */

class Solution {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
    HashSet<String> visited = new HashSet<>();

    for(int i = 0; i < equations.length; i++) {
      if(!graph.containsKey(equations[i][0])) graph.put(equations[i][0], new HashMap<>());
      if(!graph.containsKey(equations[i][1])) graph.put(equations[i][1], new HashMap<>());
      graph.get(equations[i][0]).put(equations[i][1], values[i]);
      graph.get(equations[i][1]).put(equations[i][0], 1.0/values[i]);
    }

    double[] result = new double[queries.length];
    for(int i = 0; i < queries.length; i++) {
      if(!graph.containsKey(queries[i][0]) || !graph.containsKey(queries[i][1])) {
        result[i] = -1.0;
      } else {
        result[i] = DFS(graph, queries[i][0], queries[i][1], visited);
      }
      visited.clear();
    }

    return result;
  }

  public double DFS(
    HashMap<String, HashMap<String, Double>> graph,
    String curr,
    String end,
    HashSet<String> visited
  ) {
    if(graph.get(curr).containsKey(end)) return graph.get(curr).get(end);

    visited.add(curr);

    for(Map.Entry<String, Double> entry : graph.get(curr).entrySet()) {
      if(!visited.contains(entry.getKey())) {
        double nextDFSResult = DFS(graph, entry.getKey(), end, visited);
        if(nextDFSResult != -1.0) return entry.getValue() * nextDFSResult;
      }
    }
    return -1.0;
  }
}
