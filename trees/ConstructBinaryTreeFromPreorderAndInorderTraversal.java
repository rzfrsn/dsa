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
    private int inOrderMid = -1;
    private int inOrderLeftSize = 0;
    private int inOrderRightSize = 0;

    /**
     * Pattern : Trees - DFS, split preorder/inorder via root index (naive, with array copies)
     * Time : O(n²) | Space : O(n²)
     * 105. Construct Binary Tree from Preorder and Inorder Traversal
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);
        int mid = 0;
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root.val) {
                mid = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, mid + 1),
                Arrays.copyOfRange(inorder, 0, mid)
        );

        root.right = buildTree(
                Arrays.copyOfRange(preorder, mid + 1, preorder.length),
                Arrays.copyOfRange(inorder, mid + 1, inorder.length)
        );

        return root;
    }

    /**
     * Not mine — optimized: HashMap for O(1) root lookup + index bounds instead of array copies
     * Pattern : Trees - DFS, index-based split (no array copying)
     * Time : O(n) | Space : O(n)
     */
    public TreeNode buildTreeV0(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderIndexMap);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd,
                           Map<Integer, Integer> inorderIndexMap) {
        if(preStart > preEnd) return null;

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndexMap.get(rootVal);
        int leftSize = mid - inStart;

        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, mid - 1, inorderIndexMap);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, mid + 1, inEnd, inorderIndexMap);

        return root;
    }
}
