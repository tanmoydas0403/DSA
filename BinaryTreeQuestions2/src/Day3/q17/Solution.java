package Day3.q17;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int[] kArr = new int[]{k};
        return helper(root, kArr);
    }

    private int helper(TreeNode root, int[] kArr) {
        if (root == null) return -1;

        int left = helper(root.left, kArr);
        if (left != -1) return left;

        kArr[0]--;
        if (kArr[0] == 0) return root.val;

        return helper(root.right, kArr);
    }

    public static void main(String[] args) {
        // Sample BST
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        Solution sol = new Solution();
        int k = 3;
        System.out.println("The " + k + "rd smallest element is: " + sol.kthSmallest(root, k));
    }
}