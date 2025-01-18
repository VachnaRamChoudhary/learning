package com.vachna.linkedList;

import com.vachna.modals.ListNode;
import com.vachna.utill.HelperUtil;

public class DetectCycleInLinkedList {

    public DetectCycleInLinkedList(ListNode a) {
        ListNode node = detectCycle(a);
        System.out.println("Junction point: " + (node == null? null : node.val));

    }

    public ListNode detectCycle(ListNode head) {
        ListNode junction = getCollagenPoint(head);
        if(junction == null) return  null;
        System.out.println("Collagen point: " + junction.val);

        if(junction == head) return head;

        ListNode slow = head, fast = junction;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){
                return  slow;
            }
        }
        return null;
    }

    public ListNode getCollagenPoint(ListNode head){
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a = HelperUtil.createLinkedList(3);
        ListNode b = HelperUtil.getLastNode(a);
        b.next = a;
        new DetectCycleInLinkedList(a);

    }
}
