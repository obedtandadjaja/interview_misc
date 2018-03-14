/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
*/

class TriangleMinimumSumPath {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        return findPath(triangle, dp, 0, 0);
    }
    
    public int findPath(List<List<Integer>> triangle, int[][] dp, int x, int y) {
        if(dp[x][y] != 0) {
            return dp[x][y];
        } else if(x == triangle.size()-1) {
            return triangle.get(x).get(y);
        } else {
            int first = findPath(triangle, dp, x+1, y);
            int second = findPath(triangle, dp, x+1, y+1);
            int result = triangle.get(x).get(y) + Math.min(first, second);
            dp[x][y] = result;
            return result;
        }
    }
}
