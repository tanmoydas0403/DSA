package Ques2;

import java.util.*;

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

class Tuple {
    TreeNode node;
    int col;
    int row;
    Tuple(TreeNode node, int col, int row) {
        this.node = node;
        this.col = col;
        this.row = row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new ArrayDeque<>();

        queue.offer(new Tuple(root, 0, 0));

        while (!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode node = t.node;
            int col = t.col;
            int row = t.row;

            map.computeIfAbsent(col, k -> new TreeMap<>())
                .computeIfAbsent(row, k -> new PriorityQueue<>())
                .offer(node.val);

            if (node.left != null) queue.offer(new Tuple(node.left, col - 1, row + 1));
            if (node.right != null) queue.offer(new Tuple(node.right, col + 1, row + 1));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> colList = new ArrayList<>();
            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }
            ans.add(colList);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        // Constructing the binary tree:
        //         1
        //        / \
        //       2   3
        //      / \ / \
        //     4  6 5  7

        TreeNode root = new TreeNode(1,
            new TreeNode(2, new TreeNode(4), new TreeNode(6)),
            new TreeNode(3, new TreeNode(5), new TreeNode(7))
        );

        Solution sol = new Solution();
        List<List<Integer>> result = sol.verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> col : result) {
            System.out.println(col);
        }
    }
}