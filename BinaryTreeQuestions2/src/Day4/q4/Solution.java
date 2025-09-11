package Day4.q4;
import java.util.*;

public class Solution {
    boolean findPath(TreeNode node, int[]arr){
        if (node == null) return arr.length == 0;

        return helper(node, arr, 0);
    }

    private boolean helper(TreeNode node, int[] arr, int index) {
        if (node == null) return false;

        if (index >= arr.length || node.val != arr[index]) return false;

        if (node.left == null && node.right == null && index == arr.length - 1) return true;

        return helper(node.left, arr, index + 1) || helper(node.right, arr, index + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(12);
        root.right.left.left = new TreeNode(16);
        root.right.right.left = new TreeNode(8);

        int[] arr = {3, 9, 12, 8};

        Solution sol = new Solution();
        boolean result = sol.findPath(root, arr);
        System.out.println("Path found: " + result);

        System.out.println("--------------------------------------");

        // Tree structure:
        //       1
        //      / \
        //     2   -1
        //    /   /  \
        //   1   1    2

        TreeNode root1 = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.right = new TreeNode(-1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(2);

        Solution sol1 = new Solution();
        int targetSum = 2;
        int result1 = sol.countPath(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result);

    }

    int countPath(TreeNode node, int sum){
        List<Integer> path = new LinkedList<>();
        return helper(node, sum, path);
    }

    private int helper(TreeNode node, int targetSum, List<Integer> path) {
        if (node == null) return 0;

        path.add(node.val);
        int count = 0;
        int tempSum = 0;

        // Count paths ending at current node that sum to targetSum
        ListIterator<Integer> itr = path.listIterator(path.size());
        while (itr.hasPrevious()) {
            tempSum += itr.previous();
            if (tempSum == targetSum) count++;
        }

        count += helper(node.left, targetSum, path);
        count += helper(node.right, targetSum, path);
        path.remove(path.size() - 1);
        return count;
    }

}
