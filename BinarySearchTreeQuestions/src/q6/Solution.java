package q6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    TreeNode node5 = new TreeNode(5);
    TreeNode node4 = new TreeNode(4);
    TreeNode node2 = new TreeNode(2, null, node5);
    TreeNode node3 = new TreeNode(3, null, node4);
    TreeNode root = new TreeNode(1, node2, node3);

    Solution sol = new Solution();
    List<Integer> rightView = sol.rightSideView(root);

    System.out.println("Right side view:");
    System.out.println(rightView); // Output: [1, 3, 4]
}

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

                // Add the last node of each level
                if (i == levelSize - 1) {
                    result.add(currentNode.val);
                }
            }
        }

        return result;
    }
}