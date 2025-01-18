package com.vachna.utill;

import com.vachna.modals.ListNode;

public interface HelperUtil {

    public static ListNode createLinkedList(int n) {
        if (n <= 0) {
            return null; // Return null for non-positive values of n
        }

        ListNode head = new ListNode(1); // Create the first node
        ListNode current = head;

        for (int i = 2; i <= n; i++) {
            current.next = new ListNode(i); // Create and link the next node
            current = current.next;
        }

        return head;
    }
}
