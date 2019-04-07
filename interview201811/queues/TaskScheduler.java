/*
  Difficulty: Medium

  Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

  However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

  You need to return the least number of intervals the CPU will take to finish all the given tasks.

  Example:

  Input: tasks = ["A","A","A","B","B","B"], n = 2
  Output: 8
  Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.


  Note:

  The number of tasks is in the range [1, 10000].
  The integer n is in the range [0, 100].
 */

class Solution {
  // 1: priority queue and stack
  public int leastInterval(char[] tasks, int n) {
    int count = 0;

    // count occurrence of each task
    int[] taskCounts = new int[26];
    for(int i = 0; i < tasks.length; i++)
      taskCounts[tasks[i] - 'A']++;

    // put counts into a priority queue
    PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
    for(int i = 0; i < taskCounts.length; i++) {
      if(taskCounts[i] == 0) continue;

      pq.offer(taskCounts[i]);
    }

    Stack<Integer> tasksToExecute = new Stack<>();
    int idles = 0;
    while(!pq.isEmpty()) {
      // when pq is not empty and stack size is not n yet
      while(!pq.isEmpty() && tasksToExecute.size() < n + 1) {
        tasksToExecute.push(pq.poll());
      }

      // calculate the number of idles due to lack of distinct tasks
      idles = n + 1 - tasksToExecute.size();

      // increment the count
      count += n + 1;

      // put back the tasks back to the priority queue
      while(!tasksToExecute.isEmpty()) {
        int taskCount = tasksToExecute.pop();

        if(taskCount > 1) pq.offer(taskCount - 1);
      }
    }

    // decrement the tail idles
    count -= idles;

    return count;
  }

  // 2: counting the idleSpots
  public int leastInterval(char[] tasks, int n) {
    int[] taskCounts = new int[26];
    for(char c : tasks)
      taskCounts[c - 'A']++;

    Arrays.sort(taskCounts);

    int maxVal = taskCounts[taskCounts.length - 1] - 1;
    int idleSpots = maxVal * n;
    for(int i = 0; i < 25; i++) {
      // need to do min here so that other values with val == maxVal+1 will be capped
      idleSpots -= Math.min(taskCounts[i], maxVal);
    }

    // when n = 0, idleSpots will be 0 and values will be negative on substractions
    return idleSpots > 0 ? idleSpots + tasks.length : tasks.length;
  }
}
