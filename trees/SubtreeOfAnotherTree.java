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
     * Pattern : Trees - recursive loop, subtree search, subtree comparison
     * Time : O(n x m) | Space : O(h)
     * 572. Subtree of Another Tree
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return root == subRoot;

        return isSameTree(root, subRoot) ?
                true :
                (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public boolean isSameTree(TreeNode q, TreeNode p) {
        if(p == null || q == null) return q == p;
        return q.val == p.val && isSameTree(q.left, p.left) && isSameTree(q.right, p.right);
    }
}
