package Q5;

public class Main {
    public static void main(String[] args) {
        // Constructing a BST with two nodes swapped:
        // Original BST should be: 1 → 2 → 3 → 4 → 5
        // Swapped BST: 1 → 4 → 3 → 2 → 5

        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(5);

        System.out.print("Before fix (in-order): ");
        printInOrder(root);
        System.out.println();

        TwoNodeSwap fixer = new TwoNodeSwap();
        fixer.helper(root);

        System.out.print("After fix (in-order): ");
        printInOrder(root);
        System.out.println();
    }

    public static void printInOrder(Node root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }
}