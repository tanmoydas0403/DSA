package q9;

public class Solution {

    public static void main(String[] args) {
        // Constructing a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution sol = new Solution();
        int diameter = sol.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter);
    }


    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
