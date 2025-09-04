package com.tanmoy.questions.q5;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    public ListNode detectCycle(ListNode head) {
        int length = 0;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                length = lengthCycle(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // Find the start node
        ListNode f = head;
        ListNode s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }

    private int lengthCycle(ListNode node) {
        ListNode temp = node;
        int length = 1;

        while (temp.next != node) {
            temp = temp.next;
            length++;
        }

        return length;
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

        ListNode cycleStart = solution.detectCycle(node1);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val); // Should print 2
        } else {
            System.out.println("No cycle detected.");
        }

        // 🚫 No cycle: 5 → 6 → 7 → null
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node5.next = node6;
        node6.next = node7;

        ListNode noCycle = solution.detectCycle(node5);
        if (noCycle != null) {
            System.out.println("Cycle starts at node with value: " + noCycle.val);
        } else {
            System.out.println("No cycle detected."); // Should print this
        }
    }
}
