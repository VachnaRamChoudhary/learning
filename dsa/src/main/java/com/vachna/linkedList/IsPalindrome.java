package com.vachna.linkedList;

import dsa.src.main.java.com.vachna.modals.ListNode;
import com.vachna.utill.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

    public IsPalindrome(ListNode a){
        System.out.println(isPalindrome(a));
    }

        public boolean isPalindrome(ListNode head) {
            if(head==null || head.next==null) return true;
            ListNode mid = HelperUtil.findMidOfLinkedList(head);
            mid = HelperUtil.reverseList(mid);
            while(mid != null){
                if(head.val != mid.val){
                    return false;
                }
                mid = mid.next;
                head = head.next;
            }
            return true;
        }

//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 2, 1, 2));
//        ListNode a = HelperUtil.createLinkedList(list);
//        a.printNodes();
//        new IsPalindrome(a);
//    }
}
