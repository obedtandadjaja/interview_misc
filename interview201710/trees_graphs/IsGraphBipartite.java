/* 
Given a graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.
Example 2:
Input: [[1,2,3], [0,2], [0,1,3], [0,2]]
Output: false
Explanation: 
The graph looks like this:
0----1
| \  |
|  \ |
3----2
We cannot find a way to divide the set of nodes into two independent ubsets.
*/

import java.util.*;

class IsGraphBipartite {
    public static void main(String[] args) {
        int[][] graph = new int[] { new int[] { 1, 3 }, new int[] { 0, 2 }, new int[] { 1, 3 }, new int[] { 0, 2 } };
        System.out.println(isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1);
        Stack<Integer> s = new Stack<Integer>();
        
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                s.push(i);
                
                while(!s.empty()) {
                    Integer curr = s.pop();
                    for(int neighbor : graph[curr]) {
                        if(color[neighbor] == -1) {
                            color[neighbor] = color[curr] ^ 1;
                            s.push(neighbor);
                        } else if(color[neighbor] == color[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
