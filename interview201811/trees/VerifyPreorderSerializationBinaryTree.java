/*
  Difficulty: Medium

  One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

       _9_
      /   \
     3     2
    / \   / \
   4   1  #  6
  / \ / \   / \
  # # # #   # #
  For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

  Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

  Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

  You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

  Example 1:

  Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
  Output: true
  Example 2:

  Input: "1,#"
  Output: false
  Example 3:

  Input: "9,#,#,1"
  Output: false
*/

class Solution {
  // 1 : recreate preorder traversal and act as if you are creating tree
  //     caveat: make sure count == length of values
  int index = 0;
  public boolean isValidSerialization(String preorder) {
    String[] values = preorder.split(",");
    if(values.length == 0) return false;

    return helper(values) && index >= values.length;
  }

  public boolean helper(String[] values) {
    // only happens when a node has missing nulls
    if(index >= values.length) return false;
    index++;

    // only iterate down on numeric values
    if(!values[index - 1].equals("#")) {
      return helper(values) && helper(values);
    }

    return true;
  }

  // 2 : idea is # of nulls = # of nodes + 1
  //     preorder will always record values before nulls so on null decrement
  public boolean isValidSerialization(String preorder) {
    String[] values = preorder.split(",");
    if(values.length == 0) return false;

    int count = 1;
    for(String value : values) {
      if(count < 1) return false;

      if(value.equals("#")) count--;
      else count++;
    }

    return count == 0;
  }
}
