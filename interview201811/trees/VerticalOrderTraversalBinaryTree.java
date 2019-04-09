/*
  Difficulty: Medium

  Given a binary tree, return the vertical order traversal of its nodes values.

  For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

  Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

  If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

  Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

  Example 1:

  Input: [3,9,20,null,null,15,7]
  Output: [[9],[3,15],[20],[7]]
  Explanation:
  Without loss of generality, we can assume the root node is at position (0, 0):
  Then, the node with value 9 occurs at position (-1, -1);
  The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
  The node with value 20 occurs at position (1, -1);
  The node with value 7 occurs at position (2, -2).

  Example 2:

  Input: [1,2,3,4,5,6,7]
  Output: [[4],[2],[1,5,6],[3],[7]]
  Explanation:
  The node with value 5 and the node with value 6 have the same position according to the given scheme.
  However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  int min = 0;

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Result>> map = new HashMap<>();

    helper(root, 0, map, 0);

    while(map.containsKey(min)) {
      Collections.sort(map.get(min));

      List<Integer> values = new ArrayList<>();
      for(Result r : map.get(min))
        values.add(r.node.val);

      result.add(values);
      min++;
    }

    return result;
  }

  public void helper(TreeNode root, int verticalIndex, Map<Integer, List<Result>> map, int depth) {
    if(root == null) return;

    // update the global min so that we can construct the result properly later
    min = Math.min(min, verticalIndex);

    // add the value to the map
    if(!map.containsKey(verticalIndex))
      map.put(verticalIndex, new ArrayList<>());
    map.get(verticalIndex).add(new Result(root, depth));

    helper(root.left, verticalIndex - 1, map, depth + 1);
    helper(root.right, verticalIndex + 1, map, depth + 1);
  }

  class Result implements Comparable<Result> {
    TreeNode node;
    int depth;

    public Result(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }

    public int compareTo(Result r) {
      if(this.depth == r.depth) {
        return this.node.val - r.node.val;
      } else {
        return this.depth - r.depth;
      }
    }
  }
}
