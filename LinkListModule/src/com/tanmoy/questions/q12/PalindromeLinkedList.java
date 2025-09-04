package com.tanmoy.questions.q12;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Original List:");
        printList(head);

        Solution solution = new Solution();
        boolean result = solution.isPalindrome(head);

        System.out.println("Is Palindrome? " + result);

        System.out.println("Restored List:");
        printList(head); // Should be unchanged after palindrome check
    }

    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reverseHead = headSecond;

        ListNode headFirst = head;
        boolean result = true;

        while (headSecond != null) {
            if (headFirst.val != headSecond.val) {
                result = false;
                break;
            }
            headFirst = headFirst.next;
            headSecond = headSecond.next;
        }

        reverseList(reverseHead); // Restore original list
        return result;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}