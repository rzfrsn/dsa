/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int diameter = 0;

    /**
     * Pattern : Trees - recursive loop (left and right) + value iteration + global variable
     * Time : O(n) | Space : O(n)
     * 543. Diameter of Binary Tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return diameter;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        diameter = Math.max(diameter, maxLeft + maxRight);

        return Math.max(maxLeft, maxRight) + 1;
    }
}
