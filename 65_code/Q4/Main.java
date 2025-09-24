package Q4;

public class Main {
    public static void main(String[] args) {
        // Constructing the BST:
        //        4
        //       / \
        //      2   5
        //     / \
        //    1   3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        DoubleLinkedList dll = new DoubleLinkedList();
        LLNode head = dll.convert(root);

        // Print the doubly linked list forward
        System.out.print("Forward: ");
        LLNode curr = head;
        LLNode tail = null;
        while (curr != null) {
            System.out.print(curr.val + " ");
            tail = curr;
            curr = curr.next;
        }

        // Print the doubly linked list backward
        System.out.print("\nBackward: ");
        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.prev;
        }
    }
}