package q2;

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

class Solution {

   public static void main(String[] args) {
    // 🌳 Constructing the binary tree:
    //         3
    //       /   \
    //      9    20
    //          /  \
    //         15   7

    TreeNode node7 = new TreeNode(7);
    TreeNode node15 = new TreeNode(15);
    TreeNode node20 = new TreeNode(20, node15, node7);
    TreeNode root = new TreeNode(3, new TreeNode(9), node20);

    Solution sol = new Solution();

    // ✅ Test 1: Average of levels
    List<Double> averages = sol.averageOfLevels(root);
    System.out.println("Average of each level:");
    for (int i = 0; i < averages.size(); i++) {
        System.out.printf("Level %d: %.2f\n", i, averages.get(i));
    }

    // ✅ Test 2: Find successor in level-order traversal
    int key = 9; // Change this to test different nodes
    TreeNode successor = sol.findSuccessor(root, key);

    if (successor != null) {
        System.out.println("Successor of " + key + " is: " + successor.val);
    } else {
        System.out.println("No successor found for key: " + key);
    }
}

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(sum / levelSize);
        }

        return result;
    }

   public TreeNode findSuccessor(TreeNode root, int key) {
    if (root == null) {
        return null;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode currentNode = queue.poll();

        if (currentNode.left != null) {
            queue.offer(currentNode.left);
        }

        if (currentNode.right != null) {
            queue.offer(currentNode.right);
        }

        if (currentNode.val == key) {
            break;
        }
    }

    return queue.peek(); // This is the next node in level-order
}
}