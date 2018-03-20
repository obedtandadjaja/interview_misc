/*
There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

For example:

2, [[1,0]]
There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

4, [[1,0],[2,0],[3,1],[3,2]]
There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken
after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

Hints:

This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore
it will be impossible to take all courses.
Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
Topological sort could also be done via BFS.
 */

import java.util.*;

class CourseSchedule2 {
    public static void main(String[] args) {
        int[][] prereqs = new int[][] {
            new int[] { 1,0 },
            new int[] { 2,0 },
            new int[] { 3,1 },
            new int[] { 3,2 }
        };
        int numCourses = 3;
        System.out.println(Arrays.toString(findOrder(numCourses, prereqs)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        int[] result = new int[numCourses];
        int result_i = 0;

        // initialize map
        ArrayList<ArrayList<Integer>> prereq = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) prereq.add(new ArrayList<Integer>());

        // put in values to map
        for(int i = 0; i < prerequisites.length; i++) {
            int[] curr = prerequisites[i];
            prereq.get(curr[0]).add(curr[1]);
        }

        // topological sort
        for(int i = 0; i < numCourses; i++) {
            if(visited[i] == 0) {

                // dfs
                Stack<Integer> s = new Stack<Integer>();
                s.push(i);
                while(!s.isEmpty()) {
                    int curr = s.peek();
                    if(prereq.get(curr).size() > 0) {
                        if(visited[prereq.get(curr).get(0)] == 0) s.push(prereq.get(curr).get(0));
                        prereq.get(curr).remove(0);
                    } else {
                        if(result_i >= result.length) return new int[0]; // if cyclic return empty array
                        result[result_i++] = s.pop();
                        visited[curr]++;
                    }
                }
            }
        }

        return result;
    }
}
