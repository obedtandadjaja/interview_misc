/*
  Difficulty: Medium

  You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

  struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
  }
  Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

  Initially, all next pointers are set to NULL.



  Example:
  Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}

  Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}

  Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.

  Note:

  You may only use constant extra space.
  Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 */

/*
// Definition for a Node.
class Node {
public int val;
public Node left;
public Node right;
public Node next;

public Node() {}

public Node(int _val,Node _left,Node _right,Node _next) {
val = _val;
left = _left;
right = _right;
next = _next;
}
};
*/
class Solution {
  public Node connect(Node root) {
    if(root == null) return root;

    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
      int count = q.size();
      for(int i = 0; i < count; i++) {
        Node curr = q.poll();
        if(curr.left != null) q.add(curr.left);
        if(curr.right != null) q.add(curr.right);

        if(i < count - 1) curr.next = q.peek();
      }
    }

    return root;
  }

  // approach 2: O(1) space
  public Node connect(Node root) {
    if(root == null) return null;

    connectUtil(root);
    return root;
  }

  public void connectUtil(Node root) {
    if(root.left == null && root.right == null) return;

    Node curr = root;
    Node prev = null;

    while(curr != null) {
      if(prev != null) prev.next = curr.left;

      curr.left.next = curr.right;
      prev = curr.right;
      curr = curr.next;
    }

    connectUtil(root.left);
  }
}
