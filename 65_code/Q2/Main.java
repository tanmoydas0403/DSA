package Q2;

public class Main {
    public static void main(String[] args) {
        // Constructing the BST:
        //        5
        //       / \
        //      3   6
        //     / \   \
        //    2   4   7

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        int target = 9;

        TwoSum twoSum = new TwoSum();
        boolean result = twoSum.findTarget(root, target);
        System.out.println("Pair exists with sum " + target + ": " + result);
    }
}
