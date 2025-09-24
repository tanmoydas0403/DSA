package Q5;

public class TwoNodeSwap {
    Node first;
    Node second;
    Node prev;

    public void helper(Node root) {
        iot(root);

        // Swap values of the two misplaced nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void iot(Node root) {
        if (root == null) return;

        iot(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
            }
        }

        prev = root;
        iot(root.right);
    }
}

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }
}
