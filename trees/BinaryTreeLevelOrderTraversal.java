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
     * Pattern : Trees - BFS
     * Time : O(n) | Space : O(n)
     * 102. Binary Tree Level Order Traversal
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }

            result.add(level);
        }

        return result;
    }

    // First try without Queue (FIFO)
    public List<List<Integer>> levelOrderV0(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        List<TreeNode> treesCache = new ArrayList<>();
        treesCache.add(root);

        List<Integer> valuesTmp;
        List<TreeNode> nodesTmp;

        while(!treesCache.isEmpty()) {
            nodesTmp = new ArrayList<>();
            valuesTmp = new ArrayList<>();

            for(var t : treesCache) {
                valuesTmp.add(t.val);
                if(t.left != null) nodesTmp.add(t.left);
                if(t.right != null) nodesTmp.add(t.right);
            }

            result.add(valuesTmp);
            treesCache.removeAll(treesCache);
            treesCache.addAll(nodesTmp);
        }

        return result;
    }
}
