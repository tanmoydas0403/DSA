package Q3;


class Solution {
    private int k;
    private int ans;
     public int kthSmallest(TreeNode root, int k) {
        //using heap
        this.k = k;
        helper(root);
        return ans;
    }
    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        k--;
        if (k == 0) {
            ans = root.val;
            return;
        }
        helper(root.right);
    }
        
}