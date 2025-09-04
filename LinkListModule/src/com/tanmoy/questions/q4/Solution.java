package com.tanmoy.questions.q4;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                // Calculate the length
                ListNode temp = slow;
                int length = 1;
                while (temp.next != slow) {
                    temp = temp.next;
                    length++;
                }
                return length;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 🔁 Create a cycle: 1 → 2 → 3 → 4 → 2 ...
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle starts at node2

        System.out.println("Cycle length (should be 3): " + solution.lengthCycle(node1));

        // 🚫 No cycle: 5 → 6 → 7 → null
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node5.next = node6;
        node6.next = node7;

        System.out.println("Cycle length (should be 0): " + solution.lengthCycle(node5));
    }
}
