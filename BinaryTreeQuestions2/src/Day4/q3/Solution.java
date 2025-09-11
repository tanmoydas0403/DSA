package Day4.q3;

public class Solution {
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;

        // Only include positive contributions
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));

        // Update global max if current path is better
        int currentPathSum = node.val + left + right;
        maxSum = Math.max(maxSum, currentPathSum);

        // Return max gain if continuing the same path upward
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution sol = new Solution();
        int result = sol.maxPathSum(root);
        System.out.println("Maximum path sum: " + result);
    }
}