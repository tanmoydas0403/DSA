package Day2.q12;

public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);

        return root;
    }

    // Preorder traversal to display the tree
    public static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        Solution sol = new Solution();
        TreeNode bstRoot = sol.sortedArrayToBST(nums);

        System.out.print("Preorder Traversal of BST: ");
        preorder(bstRoot);
    }
}