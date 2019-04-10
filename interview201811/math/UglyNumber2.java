/*
  Difficulty: Medium

  Write a program to find the n-th ugly number.

  Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

  Example:

  Input: n = 10
  Output: 12
  Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 */

class Solution {
  // 1: 3 queues, 1 visited set
  // idea: n-1 ugly number will be *2/*3/*5 to generate next ugly numbers
  //       create a queue for each, and determine the min and generate the number
  public int nthUglyNumber(int n) {
    Queue<Integer> q2 = new LinkedList();
    Queue<Integer> q3 = new LinkedList();
    Queue<Integer> q5 = new LinkedList();

    Set<Integer> visited = new HashSet();
    visited.add(1);

    q2.offer(1); q3.offer(1); q5.offer(1);

    int count = 1;
    int prev = 1;
    while(count < n) {
      if(q2.peek() * 2 <= q3.peek() * 3 &&
         q2.peek() * 2 <= q5.peek() * 5) {
        if(visited.contains(q2.peek() * 2)) {
          q2.poll();
          continue;
        } else {
          q2.offer(q2.peek() * 2);
          q3.offer(q2.peek() * 2);
          q5.offer(q2.peek() * 2);
          prev = q2.poll() * 2;
        }
      } else if(q3.peek() * 3 <= q2.peek() * 2 &&
                q3.peek() * 3 <= q5.peek() * 5) {
        if(visited.contains(q3.peek() * 3)) {
          q3.poll();
          continue;
        } else {
          q2.offer(q3.peek() * 3);
          q3.offer(q3.peek() * 3);
          q5.offer(q3.peek() * 3);
          prev = q3.poll() * 3;
        }
      } else {
        if(visited.contains(q5.peek() * 5)) {
          q5.poll();
          continue;
        } else {
          q2.offer(q5.peek() * 5);
          q3.offer(q5.peek() * 5);
          q5.offer(q5.peek() * 5);
          prev = q5.poll() * 5;
        }
      }

      count++;
      visited.add(prev);
    }

    return prev;
  }

  // 2: same idea, less complicated
  public int nthUglyNumber(int n) {
    // store 0 - n ugly numbers
    int[] dp = new int[n+1];
    dp[1] = 1;

    int index_2 = 1,index_3 = 1,index_5 = 1;
    for(int i = 2; i <= n; i++){
      dp[i] = Math.min(2 * dp[index_2], Math.min(3 * dp[index_3], 5 * dp[index_5]));

      // increment indexes which result in the new min
      if(2 * dp[index_2] == dp[i]) index_2++;
      if(3 * dp[index_3] == dp[i]) index_3++;
      if(5 * dp[index_5] == dp[i]) index_5++;
    }

    return dp[n];
  }
}
