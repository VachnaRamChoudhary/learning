package com.vachna.linkedList;

import com.vachna.modals.ListNode;
import com.vachna.utill.HelperUtil;


public class ReverseNodesInKGroup {

    public ReverseNodesInKGroup(ListNode head){
        head.printNodes();
//        head = reverseList(head);
//        head.printNodes();
        head = reverseKGroup(head, 2);
        head.printNodes();

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0); // Dummy node to simplify edge cases
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check if there are at least k nodes left
            ListNode kthNode = getKthNode(prevGroupEnd, k);
            if (kthNode == null) {
                break;
            }

            // Mark the start and end of the current group
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = kthNode.next;

            // Detach the group and reverse it
            kthNode.next = null;
            ListNode newGroupStart = HelperUtil.reverseList(groupStart);

            // Connect the reversed group back to the main list
            prevGroupEnd.next = newGroupStart;
            groupStart.next = groupEnd;

            // Update prevGroupEnd to the end of the reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }


    private ListNode getKthNode(ListNode node, int k) {
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

//    public static void main(String[] args) {
//        ListNode n1 = HelperUtil.createLinkedList(16);
//        ReverseNodesInKGroup n = new ReverseNodesInKGroup(n1);
//
//    }
}
