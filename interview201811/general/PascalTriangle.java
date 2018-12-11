/*
	Difficulty: Easy
	Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.

	Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

	In Pascal's triangle, each number is the sum of the two numbers directly above it.

	Example:

	Input: 5
	Output:
	[
	[1],
	[1,1],
	[1,2,1],
  [1,3,3,1],
	[1,4,6,4,1]
	]
 */

import java.util.*;

class PascalTriangle {
  public List<List<Integer>> generate(int numRows) {
    if(numRows == 0) return new ArrayList<List<Integer>>();

    List<List<Integer>> lists = new ArrayList<List<Integer>>();

    List<Integer> first_list = new ArrayList<Integer>();
    first_list.add(1);
    lists.add(first_list);

    if(numRows < 2) return lists;

    List<Integer> prev_list = lists.get(0);
    List<Integer> curr_list = null;
    for(int i = 2; i <= numRows; i++) {
      curr_list = new ArrayList<Integer>();
      curr_list.add(1);
      for(int j = 1; j < i-1; j++) curr_list.add(prev_list.get(j-1) + prev_list.get(j));
      curr_list.add(1);
      lists.add(curr_list);

      prev_list = curr_list;
    }

    return lists;
  }
}
