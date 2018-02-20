// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
// Construct the maximum tree by the given array and output the root node of this tree.

// Example 1:
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:

//       6
//     /   \
//    3     5
//     \    /
//      2  0
//        \
//         1

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            TreeNode parent = null;
            TreeNode curr = root;
            while(curr != null && curr.val > nums[i]) {
                parent = curr;
                curr = curr.right;
            }

            if(curr == root) {
                TreeNode newNode = new TreeNode(nums[i]);
                newNode.left = root;
                root = newNode;
            } else if(curr == null) {
                parent.right = new TreeNode(nums[i]);
            } else {
                TreeNode newNode = new TreeNode(nums[i]);
                newNode.left = curr;
                parent.right = newNode;
            }
        }

        return root;
    }

    // recursive solution
    public TreeNode constructMaximumBinaryTree2(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    public TreeNode buildTree(int nums[], int start, int end) {
        if(start > end && end < nums.length) return null;

        int max = start;
        for(int i = start + 1; i <= end; i++) max = nums[max] < nums[i] ? i : max;

        TreeNode root = new TreeNode(nums[max]);
        root.left = buildTree(nums, start, max-1);
        root.right = buildTree(nums, max+1, end);

        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
