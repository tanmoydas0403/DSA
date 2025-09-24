package Q4;

public class DoubleLinkedList {
    LLNode head;
    LLNode tail;

    public LLNode convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        helper(root);
        return head;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);

        LLNode newNode = new LLNode(root.val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        helper(root.right);
    }
}

class LLNode {
    int val;
    LLNode next;
    LLNode prev;

    public LLNode(int val) {
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}