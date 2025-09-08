package q8;

import java.util.LinkedList;
import java.util.Queue;

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

public class Solution {

    public static void main(String[] args) {
        // Constructing the symmetric tree
        TreeNode node3a = new TreeNode(3);
        TreeNode node4a = new TreeNode(4);
        TreeNode node2a = new TreeNode(2, node3a, node4a);

        TreeNode node4b = new TreeNode(4);
        TreeNode node3b = new TreeNode(3);
        TreeNode node2b = new TreeNode(2, node4b, node3b);

        TreeNode root = new TreeNode(1, node2a, node2b);

        Solution sol = new Solution();
        boolean result = sol.isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result); // Expected: true
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // Enqueue children in mirrored order
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }
}
