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
     * Pattern : Trees - recursive loop on tree (left then right)
     * Time : O(n) | Space : O(h) where h = tree height (O(log n) balanced, O(n) worst case)
     * 226. Invert Binary Tree
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        var tmp1 = root.left;
        var tmp2 = root.right;
        root.left = tmp2;
        root.right = tmp1;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
