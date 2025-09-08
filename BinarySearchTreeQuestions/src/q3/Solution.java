package q3;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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
    TreeNode node7 = new TreeNode(7);
    TreeNode node15 = new TreeNode(15);
    TreeNode node20 = new TreeNode(20, node15, node7);
    TreeNode root = new TreeNode(3, new TreeNode(9), node20);

    Solution sol = new Solution();
    List<List<Integer>> zigzag = sol.zigzagLevelOrder(root);

    for (List<Integer> level : zigzag) {
        System.out.println(level);
    }
}


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
        return result;
    }

    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    boolean reverse = false;

    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();

        for (int i = 0; i < levelSize; i++) {
            if (!reverse) {
                TreeNode currentNode = queue.pollFirst();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offerLast(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offerLast(currentNode.right);
                }
            } else {
                TreeNode currentNode = queue.pollLast();
                currentLevel.add(currentNode.val);

                // Note: reverse order of children for right-to-left traversal
                if (currentNode.right != null) {
                    queue.offerFirst(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.offerFirst(currentNode.left);
                }
            }
        }

        result.add(currentLevel);
        reverse = !reverse; // Toggle after each level
    }

    return result;
}
    
}
