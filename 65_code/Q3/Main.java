package Q3;

public class Main {
    public static void main(String[] args) {
        // Constructing the BST:
        //        5
        //       / \
        //      3   6
        //     / \
        //    2   4

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        int k = 3;

        Solution solution = new Solution();
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "rd smallest element is: " + result);
    }
}

