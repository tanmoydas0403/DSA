package com.tanmoy.questions.q3;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 🔁 Create a cycle: 1 -> 2 -> 3 -> 4 -> 2 ...
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle here

        System.out.println("Cycle detected (should be true): " + solution.hasCycle(node1));

        // 🚫 No cycle: 5 -> 6 -> 7 -> null
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node5.next = node6;
        node6.next = node7;

        System.out.println("Cycle detected (should be false): " + solution.hasCycle(node5));
    }
}