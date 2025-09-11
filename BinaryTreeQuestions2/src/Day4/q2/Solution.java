package Day4.q2;

public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) return sum;

        return helper(node.left, sum) + helper(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        Solution sol = new Solution();
        int result = sol.sumNumbers(root);
        System.out.println("Sum of root-to-leaf numbers: " + result);
    }
}
