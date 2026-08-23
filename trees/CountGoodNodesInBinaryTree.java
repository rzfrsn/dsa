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
    /**
     * Pattern : Trees - DFS, pass max-so-far as parameter (not global state)
     * Time : O(n) | Space : O(n)
     * 1448. Count Good Nodes in Binary Tree
     */
    public int goodNodes(TreeNode root) {
        if(root == null) return 0;
        return count(root, root.val);
    }

    private int count(TreeNode node, int maxSoFar) {
        if(node == null) return 0;

        int count = (node.val >= maxSoFar) ? 1 : 0;
        int newMax = Math.max(maxSoFar, node.val);

        count += count(node.left, newMax);
        count += count(node.right, newMax);

        return count;
    }
}
