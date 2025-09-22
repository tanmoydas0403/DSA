package Ques1;
import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class AdvanceTreeQues01 {

    static int index = 0;

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        AdvanceTreeQues01 obj = new AdvanceTreeQues01();
        TreeNode root = obj.buildTree(preorder, inorder);

        System.out.print("Inorder traversal of constructed tree: ");
        printInorder(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        index = 0; // reset index before building
        return helper(preorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int left, int right, HashMap<Integer, Integer> map) {
        if (left > right) return null;

        int current = preorder[index++];
        TreeNode node = new TreeNode(current);

        if (left == right) return node;

        int mid = map.get(current);
        node.left = helper(preorder, left, mid - 1, map);
        node.right = helper(preorder, mid + 1, right, map);
        return node;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
}