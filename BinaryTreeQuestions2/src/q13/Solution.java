package q13;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode rightMost = current.left;
                while (rightMost.right != null) {
                    rightMost = rightMost.right;
                }
                rightMost.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Helper method to print the flattened tree
    public static void printFlattened(TreeNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample tree:
        //       1
        //      / \
        //     2   5
        //    / \   \
        //   3   4   6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution sol = new Solution();
        sol.flatten(root);

        System.out.print("Flattened Tree: ");
        printFlattened(root);
    }
}