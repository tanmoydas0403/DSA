package Q2;

import java.util.HashSet;

public class TwoSum {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>(); // HashSet to store unique elements
        return findTargetHelper(root, k, set);
    }



    private boolean findTargetHelper(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return false;

        if (set.contains(k - root.val)) return true;

        set.add(root.val);

        return findTargetHelper(root.left, k, set) || findTargetHelper(root.right, k, set);
    }
}