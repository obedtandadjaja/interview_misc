/*
  Difficulty: Medium

  Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

  Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

  The encoded string should be as compact as possible.

  Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */

// approach 1: do preorder serialization with "n" to mark as null
//             iterate through the values recursively
public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);

    return sb.toString();
  }

  public void preorder(TreeNode root, StringBuilder sb) {
    if(root == null) {
      sb.append("n" + " "); // represent null
      return;
    }

    sb.append(root.val + " ");
    preorder(root.left, sb);
    preorder(root.right, sb);
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] valuesDelimited = data.split(" ");

    LinkedList<String> values = new LinkedList<>();
    for(String s : valuesDelimited) values.add(s);

    return deserializeUtil(values);
  }

  public TreeNode deserializeUtil(LinkedList<String> values) {
    TreeNode root = createTreeNode(values.removeFirst());

    if(root != null) {
      root.left = deserializeUtil(values);
      root.right = deserializeUtil(values);
    }

    return root;
  }

  public TreeNode createTreeNode(String value) {
    if(value.equals("n")) return null;

    return new TreeNode(Integer.parseInt(value));
  }
}

// approach 2: do postorder traversal (preorder works too)
//             iterate through the values and keep adding it to the tree
//             from the root. What matters is the order of the addition
public class Codec {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    if(root == null) return null;

    StringBuilder sb = new StringBuilder();
    postorder(root, sb);

    return sb.toString();
  }

  public void postorder(TreeNode root, StringBuilder sb) {
    if(root == null) return;

    postorder(root.left, sb);
    postorder(root.right, sb);
    sb.append(root.val + " ");
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if(data == null || data.length() == 0) return null;

    String[] values = data.split(" ");

    TreeNode root = new TreeNode(Integer.parseInt(values[values.length - 1]));

    for(int i = values.length - 2; i >= 0; i--) {
      int value = Integer.parseInt(values[i]);

      TreeNode curr = root;
      while(curr != null) {
        if(value > curr.val) {
          if(curr.right == null) {
            curr.right = new TreeNode(value);
            break;
          }
          curr = curr.right;
        } else {
          if(curr.left == null) {
            curr.left = new TreeNode(value);
            break;
          }
          curr = curr.left;
        }
      }
    }

    return root;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
