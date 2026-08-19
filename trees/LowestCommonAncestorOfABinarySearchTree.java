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
    /**
     * Pattern : BST - exploit ordering property to navigate toward LCA
     * Time : O(h) | Space : O(h)
     * 235. Lowest Common Ancestor of a Binary Search Tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    // ‼️ This is not mine but space complexity is O(1)
    public TreeNode lowestCommonAncestor_not_mine(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            } else if(p.val > root.val && q.val> root.val ){
                root = root.right;
            } else{
                return root;
            }
        }
        return null;
    }
}
