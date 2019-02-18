/*
  Difficulty: Medium

  Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

  Note:

  If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
  All airports are represented by three capital letters (IATA code).
  You may assume all tickets form at least one valid itinerary.
  Example 1:

  Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
  Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
  Example 2:

  Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
  Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
  Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
  But it is larger in lexical order.
 */

class Solution {
  public List<String> findItinerary(String[][] tickets) {
    HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

    for(int i = 0; i < tickets.length; i++) {
      if(!graph.containsKey(tickets[i][0])) graph.put(tickets[i][0], new PriorityQueue<String>());
      graph.get(tickets[i][0]).add(tickets[i][1]);
    }

    return DFS(graph, "JFK");
  }

  public List<String> DFS(HashMap<String, PriorityQueue<String>> graph, String curr) {
    List<String> result = new ArrayList<String>();

    while(graph.containsKey(curr) && !graph.get(curr).isEmpty()) {
      List<String> nextItinerary = DFS(graph, graph.get(curr).poll());

      if(graph.get(curr).isEmpty() && nextItinerary.get(nextItinerary.size() - 1).equals(curr)) {
        nextItinerary.addAll(result);
        result = nextItinerary;
      } else {
        result.addAll(nextItinerary);
      }
    }

    result.add(0, curr);
    return result;
  }
}
