package com.vachna.linkedList;

import com.vachna.modals.ListNode;
import com.vachna.utill.HelperUtil;

public class RotateList {
    public RotateList(ListNode a, int i) {
        a.printNodes();
        a = rotateRight(a, i);
        a.printNodes();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        ListNode f = head, s = head;
        while(k > 0){
            s = s.next;
            k--;
            if(s == null) s = head;
        }
        while(s.next != null){
            s = s.next;
            f = f.next;
        }

        ListNode newHead = f.next;
        if(newHead == null) return  head;
        f.next = null;
        s.next = head;
        return  newHead;
    }
//
//    public static void main(String[] args) {
//        ListNode a = HelperUtil.createLinkedList(9);
//        new RotateList(a, 0);
//    }
}
