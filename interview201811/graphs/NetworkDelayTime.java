/*
  Difficulty: Medium

  There are N network nodes, labelled 1 to N.

  Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

  Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

  Note:

  N will be in the range [1, 100].
  K will be in the range [1, N].
  The length of times will be in the range [1, 6000].
  All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
 */

class Solution {
  public int networkDelayTime(int[][] times, int N, int K) {
    List<HashMap<Integer, Integer>> graph = new ArrayList<>();

    for(int i = 0; i < N; i++) graph.add(new HashMap<>());
    for(int i = 0; i < times.length; i++) {
      graph.get(times[i][0] - 1).put(times[i][1] - 1, times[i][2]);
    }

    int[] lookup = new int[N];
    Arrays.fill(lookup, Integer.MAX_VALUE);

    DFS(graph, lookup, K - 1, 0);

    int max = Integer.MIN_VALUE;
    for(int i = 0; i < N; i++) {
      if(i == K - 1) continue;
      if(lookup[i] == Integer.MAX_VALUE) return -1;

      max = Math.max(max, lookup[i]);
    }

    return max;
  }

  public void DFS(List<HashMap<Integer, Integer>> graph, int[] lookup, int src, int currTime) {
    if(lookup[src] > currTime) {
      lookup[src] = currTime;

      for(Map.Entry<Integer, Integer> next : graph.get(src).entrySet()) {
        DFS(graph, lookup, next.getKey(), currTime + next.getValue());
      }
    }
  }
}
