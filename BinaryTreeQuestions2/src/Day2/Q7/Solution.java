package Day2.Q7;

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
        // Constructing the tree
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, null);
        TreeNode node3 = new TreeNode(3, null, node5);
        TreeNode root = new TreeNode(1, node2, node3);

        Solution sol = new Solution();

        // Test case 1: 4 and 5 are cousins
        boolean result1 = sol.isCousins(root, 4, 5);
        System.out.println("Are 4 and 5 cousins? " + result1); // true

        // Test case 2: 2 and 3 are not cousins (they're siblings)
        boolean result2 = sol.isCousins(root, 2, 3);
        System.out.println("Are 2 and 3 cousins? " + result2); // false

        // Test case 3: 4 and 3 are not cousins (different levels)
        boolean result3 = sol.isCousins(root, 4, 3);
        System.out.println("Are 4 and 3 cousins? " + result3); // false
    }

    public boolean isCousins(TreeNode root, int x, int y){
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);

        return (
                (level(root, xx, 0) == level(root, yy , 0)) && (!isSibling(root, xx, yy))
        );
    }

    private int level(TreeNode node, TreeNode x, int lev) {
        if(node == null) return 0;
        if (node == x) return lev;

        int l = level(node.left, x, lev + 1);

        if(l != 0) return l;
        return level(node.right, x, lev + 1);

    }

    private boolean isSibling(TreeNode node, TreeNode x, TreeNode y) {
        if(node == null) return false;

        return (
                (node.left == x && node.right == y) || (node.left == y && node.right == x)
                        || isSibling(node.left, x, y) || isSibling(node.right, x, y)
                );
    }

    private TreeNode findNode(TreeNode node, int x) {
        if(node == null) return null;
        if(node.val == x) return node;

        TreeNode n = findNode(node.left, x);
        if(n != null) return n;
        return findNode(node.right, x);
    }
}
